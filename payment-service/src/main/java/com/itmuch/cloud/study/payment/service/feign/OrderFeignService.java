package com.itmuch.cloud.study.payment.service.feign;

import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.beans.OrderDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.remote.order-service}",path = "/rest/order")
public interface OrderFeignService {

    @RequestMapping(value = "/getOrderInfoById",method = RequestMethod.GET)
    Result<OrderDTO> getOrderInfoById(@RequestParam(value = "orderId") Long orderId);

    @RequestMapping(value = "/updateOrderStatus",method = RequestMethod.GET)
    Result<Boolean> updateOrderStatus(@RequestParam(value = "orderId") Long orderId, @RequestParam(value = "payStatus") Integer payStatus);
}
