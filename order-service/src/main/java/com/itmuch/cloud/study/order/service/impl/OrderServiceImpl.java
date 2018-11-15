package com.itmuch.cloud.study.order.service.impl;

import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.validator.Assert;
import com.itmuch.cloud.study.order.dao.OrderInfoDao;
import com.itmuch.cloud.study.order.entity.OrderInfo;
import com.itmuch.cloud.study.order.service.OrderService;
import com.itmuch.cloud.study.order.service.feign.CommodityFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private CommodityFeignService commodityFeignService;

    @Override
    public void createOrder(Long userId, Long commodityId, Integer purchaseCount) {
        //查询商品库存
        Result<Integer> stockResult = commodityFeignService.getCommodityCountById(commodityId);
        Assert.isTrue(!stockResult.isSuccess(),stockResult.getMessage());
        Integer stockNum = stockResult.getData();
        Assert.isTrue(stockNum<purchaseCount,"库存不足");

        //创建订单
        OrderInfo order = new OrderInfo();
        order.setUserId(userId);
        order.setCommodityId(commodityId);
        order.setPurchaesCount(purchaseCount);
        order.setPayStatus(0);
        orderInfoDao.save(order);

        //扣减库存(失败则回滚业务)
        Result<Boolean> result1 = commodityFeignService.updateStockByCommodityId(commodityId,-purchaseCount);

    }

    @Override
    public OrderInfo getById(Long id) {
        return orderInfoDao.getById(id);
    }

    @Override
    public int updateById(OrderInfo orderInfo) {
        return orderInfoDao.updateById(orderInfo);
    }
}
