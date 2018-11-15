package com.itmuch.cloud.study.payment.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.itmuch.cloud.study.common.base.BaseController;
import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.base.Results;
import com.itmuch.cloud.study.common.validator.Assert;
import com.itmuch.cloud.study.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/payment")
@Api(tags = "1.1", description = "支付服务", value = "支付服务")
public class PaymentController extends BaseController {

    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "/rest/payment/makePayment",notes = "创建支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId" ,value = "用户ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "orderId" ,value = "订单ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("makePayment")
    public Result<Boolean> makePayment(Long orderId, Long userId){
        Assert.isNull(orderId,"订单ID不能为空");
        Assert.isNull(userId,"用户ID不能为空");
        paymentService.makePayment(orderId,userId);
        return Results.newSuccessResult(true);
    }

}
