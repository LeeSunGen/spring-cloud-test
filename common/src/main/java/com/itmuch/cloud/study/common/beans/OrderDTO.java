package com.itmuch.cloud.study.common.beans;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;

    private Long userId;

    private Long commodityId;

    private Integer purchaesCount;

    private Integer payStatus;
}
