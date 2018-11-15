package com.itmuch.cloud.study.payment.service.impl;

import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.beans.OrderDTO;
import com.itmuch.cloud.study.common.validator.Assert;
import com.itmuch.cloud.study.payment.dao.PaymentDao;
import com.itmuch.cloud.study.payment.entity.Payment;
import com.itmuch.cloud.study.payment.service.PaymentService;
import com.itmuch.cloud.study.payment.service.feign.AccountFeignService;
import com.itmuch.cloud.study.payment.service.feign.CommodityFeignService;
import com.itmuch.cloud.study.payment.service.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private OrderFeignService orderFeignService;
    @Autowired
    private AccountFeignService accountFeignService;
    @Autowired
    private CommodityFeignService commodityFeignService;

    @Override
    public void makePayment(Long orderId, Long userId) {
        //查询订单
        Result<OrderDTO> orderDTOResult = orderFeignService.getOrderInfoById(orderId);
        Assert.isTrue(!orderDTOResult.isSuccess(), orderDTOResult.getMessage());
        OrderDTO orderDTO = orderDTOResult.getData();
        Assert.isTrue(orderDTO.getPayStatus() ==1,"订单已支付");

        //计算订单金额
        Result<Long> result1 = commodityFeignService.getPriceById(orderDTO.getCommodityId());
        Assert.isTrue(!result1.isSuccess(),result1.getMessage());
        Long price = result1.getData();
        Long purchaseTotalAmount = price * orderDTO.getPurchaesCount();
        //判断支付余额
        Result<Long> result2 = accountFeignService.getBalanceByUserId(userId);
        Assert.isTrue(!result2.isSuccess(),result1.getMessage());
        Long balance = result2.getData();
        Assert.isTrue(balance<purchaseTotalAmount,"余额不足");
        //扣除用户金额
        Result<Boolean> result3 = accountFeignService.updateBalanceByUserId(userId,-purchaseTotalAmount);
        Assert.isTrue(!result3.isSuccess(),result1.getMessage());
        //更新订单状态
        Result<Boolean> result4 = orderFeignService.updateOrderStatus(orderId,1);
        Assert.isTrue(!result4.isSuccess(),result1.getMessage());
        //创建支付流水
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setTransId(UUID.randomUUID().toString());
        payment.setChargeAmount(purchaseTotalAmount);
        paymentDao.save(payment);


    }
}
