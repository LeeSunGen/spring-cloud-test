package com.itmuch.cloud.study.account.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountQO {

    private Long id;

    private Long userId;

    private Long accountBalance;

    private String createPerson;

    private Date createTime;

    private String updatePerson;

    private Date updateTime;
    /**修改余额的值(正数表示加法,负数表示减法)*/
    private Long amount;
    /**余额总值*/
    private Long totalAmount;
}
