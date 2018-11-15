package com.itmuch.cloud.study.order.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.itmuch.cloud.study.common.base.BaseController;
import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.base.Results;
import com.itmuch.cloud.study.common.beans.OrderDTO;
import com.itmuch.cloud.study.common.validator.Assert;
import com.itmuch.cloud.study.order.entity.OrderInfo;
import com.itmuch.cloud.study.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/order")
@Api(tags = "1.1", description = "订单服务", value = "订单服务")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "/rest/order/createOrder",notes = "创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId" ,value = "用户ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "commodityId" ,value = "商品ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "purchaseCount" ,value = "数量" ,dataType = ApiDataType.INT ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("createOrder")
    public Result<Boolean> createOrder(Long userId, Long commodityId, Integer purchaseCount){
        Assert.isNull(userId,"用户Id不为空");
        Assert.isNull(commodityId,"商品Id不为空");
        Assert.isNull(purchaseCount,"购买数量不能为空");
        orderService.createOrder(userId, commodityId,purchaseCount);
        return Results.newSuccessResult(true);
    }

    @ApiOperation(value = "/rest/order/getOrderInfoById",notes = "查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId" ,value = "订单ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("getOrderInfoById")
    public Result<OrderDTO> getOrderInfoById(Long orderId){
        Assert.isNull(orderId,"订单Id不能为空");
        OrderInfo orderInfo = orderService.getById(orderId);
        Assert.isNull(orderInfo,"订单不存在");
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderInfo,orderDTO);
        return Results.newSuccessResult(orderDTO);
    }
    @ApiOperation(value = "/rest/order/updateOrderStatus",notes = "更新订单状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId" ,value = "订单ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "payStatus" ,value = "状态值" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("updateOrderStatus")
    public Result<Boolean> updateOrderStatus(Long orderId, Integer payStatus){
        Assert.isNull(orderId,"订单Id不能为空");
        Assert.isNull(payStatus,"状态不能为空");
        OrderInfo orderInfo = orderService.getById(orderId);
        Assert.isNull(orderInfo,"订单不存在");
        orderInfo.setPayStatus(payStatus);
        int num = orderService.updateById(orderInfo);
        return Results.newSuccessResult(true);
    }


}
