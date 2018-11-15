package com.itmuch.cloud.study.account.test;

import com.alibaba.fastjson.JSON;
import com.itmuch.cloud.study.account.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {

    @Autowired
    private AccountController accountController;

    @Test
    public void getBalanceByUserId(){
        System.out.println(JSON.toJSONString(accountController.getBalanceByUserId(1L)));
    }

    @Test
    public void updateBalanceByUserId(){
        System.out.println(JSON.toJSONString(accountController.updateBalanceByUserId(1L,-300L)));
    }
}
