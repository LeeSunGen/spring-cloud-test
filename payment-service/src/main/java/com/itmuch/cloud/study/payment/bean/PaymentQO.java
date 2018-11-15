package com.itmuch.cloud.study.payment.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentQO {
    private Long id;

    private String transId;

    private Long orderId;

    private Long chargeAmount;

    private String createPerson;

    private Date createTime;

    private String updatePerson;

    private Date updateTime;
}
