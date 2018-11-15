package com.itmuch.cloud.study.order.service;

import com.itmuch.cloud.study.order.entity.OrderInfo;

public interface OrderService {

    void createOrder(Long userId, Long commodityId, Integer purchaseCount);

    OrderInfo getById(Long id);

    int  updateById(OrderInfo orderInfo);
}
