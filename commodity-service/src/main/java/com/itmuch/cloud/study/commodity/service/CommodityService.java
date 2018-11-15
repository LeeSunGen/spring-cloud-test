package com.itmuch.cloud.study.commodity.service;

import com.itmuch.cloud.study.commodity.entity.Commodity;

public interface CommodityService {

    Commodity getById(Long id);

    int updateById(Commodity record);
}
