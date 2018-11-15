package com.itmuch.cloud.study.commodity.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommodityQO {
    private Long id;

    private String name;

    private Long price;

    private Integer count;

    private String createPerson;

    private Date createTime;

    private String updatePerson;

    private Date updateTime;
}
