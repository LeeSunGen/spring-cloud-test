package com.itmuch.cloud.study.order.controller.test;

import com.alibaba.fastjson.JSON;
import com.itmuch.cloud.study.order.controller.OrderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Test
    public void createOrder(){
        System.out.println(JSON.toJSONString(orderController.createOrder(1L,1L,1)));
    }
}
