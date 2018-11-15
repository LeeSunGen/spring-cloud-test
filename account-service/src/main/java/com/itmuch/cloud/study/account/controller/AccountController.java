package com.itmuch.cloud.study.account.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.itmuch.cloud.study.account.bean.AccountQO;
import com.itmuch.cloud.study.account.entity.Account;
import com.itmuch.cloud.study.account.service.AccountService;
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

import java.util.List;

@RestController
@RequestMapping("/rest/account")
@Api(tags = "1.1", description = "账户服务", value = "账户服务")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "/account/getBalanceByUserId",notes = "查询余额")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId" ,value = "用户ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("getBalanceByUserId")
    public Result<Long> getBalanceByUserId(Long userId){
        Assert.isNull(userId,"用户Id不能为空");
        List<Account> accountList = accountService.queryForList(AccountQO.builder().userId(userId).build());
        Assert.isTrue(CollectionUtil.isEmpty(accountList),"账户不存在");
        return Results.newSuccessResult(accountList.get(0).getAccountBalance());
    }

    @ApiOperation(value = "/account/updateBalanceByUserId",notes = "更新余额")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId" ,value = "用户ID" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "amount" ,value = "修改值" ,dataType = ApiDataType.LONG ,paramType = ApiParamType.QUERY)
    })
    @GetMapping("updateBalanceByUserId")
    public Result<Boolean> updateBalanceByUserId(Long userId, Long amount){
        Assert.isNull(userId, "用户ID不能为空");
        Assert.isNull(amount,"修改值不能为空");
        List<Account> accountList = accountService.queryForList(AccountQO.builder().userId(userId).build());
        Assert.isTrue(CollectionUtil.isEmpty(accountList),"账户不存在");
        Account account = accountList.get(0);
        int num = accountService.updateByExampleSelective(AccountQO.builder().userId(userId).totalAmount(account.getAccountBalance()+amount).build());
        Assert.isTrue(num < 0,"更新账户余额失败");
        return Results.newSuccessResult(true);
    }

}
