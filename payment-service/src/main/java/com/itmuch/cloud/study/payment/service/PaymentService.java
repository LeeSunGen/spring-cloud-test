package com.itmuch.cloud.study.payment.service;

public interface PaymentService {

    void makePayment(Long orderId, Long userId);

}
