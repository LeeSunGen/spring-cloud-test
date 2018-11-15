package com.itmuch.cloud.study.commodity.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.itmuch.cloud.study.commodity.entity.Commodity;
import com.itmuch.cloud.study.commodity.service.CommodityService;
import com.itmuch.cloud.study.common.base.BaseController;
import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.base.Results;
import com.itmuch.cloud.study.common.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/commodity")
@Api(tags = "1.1", description = "商品服务", value = "商品服务")
public class CommodityController  extends BaseController {

    @Autowired
    private CommodityService commodityService;

    @ApiOperation(value = "/rest/commodity/getCountById",notes = "查询库存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityId" ,value = "商品ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("getCountById")
    public Result<Integer> getCountById(Long commodityId){
        Assert.isNull(commodityId,"Id不能为空");
        Commodity commodity = commodityService.getById(commodityId);
        Assert.isNull(commodity,"商品不存在");
        return Results.newSuccessResult(commodity.getCount());
    }

    @ApiOperation(value = "/rest/commodity/updateStock",notes = "更新库存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityId" ,value = "商品ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "amount" ,value = "修改值" ,dataType = ApiDataType.INT ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("updateStock")
    public Result<Boolean> updateStock(Long commodityId, Integer amount){
        Assert.isNull(commodityId,"商品Id不能为空");
        Assert.isNull(amount,"修改值不能为空");
        Commodity commodity = commodityService.getById(commodityId);
        Assert.isNull(commodity,"商品不存在");
        commodity.setCount(commodity.getCount()+amount);
        int num = commodityService.updateById(commodity);
        Assert.isTrue(num<0,"更新失败");
        return Results.newSuccessResult(true);
    }

    @ApiOperation(value = "/rest/commodity/getPriceById",notes = "查询价格")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityId" ,value = "商品ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("getPriceById")
    public Result<Long> getPriceById(Long commodityId){
        Assert.isNull(commodityId,"Id不能为空");
        Commodity commodity = commodityService.getById(commodityId);
        Assert.isNull(commodity,"商品不存在");
        return Results.newSuccessResult(commodity.getPrice());
    }



}
