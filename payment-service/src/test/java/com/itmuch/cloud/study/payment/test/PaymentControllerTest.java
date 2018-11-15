package com.itmuch.cloud.study.payment.test;

import com.alibaba.fastjson.JSON;
import com.itmuch.cloud.study.payment.controller.PaymentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {
    @Autowired
    private PaymentController paymentController;

    @Test
    public void makePayment(){
        System.out.println(JSON.toJSONString(paymentController.makePayment(2L,1L)));
    }


}
