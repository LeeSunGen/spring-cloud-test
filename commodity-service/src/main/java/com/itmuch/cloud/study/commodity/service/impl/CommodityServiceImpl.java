package com.itmuch.cloud.study.commodity.service.impl;

import com.itmuch.cloud.study.commodity.dao.CommodityDao;
import com.itmuch.cloud.study.commodity.entity.Commodity;
import com.itmuch.cloud.study.commodity.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public Commodity getById(Long id) {
        return commodityDao.getById(id);
    }

    @Override
    public int updateById(Commodity record) {
        return commodityDao.updateById(record);
    }
}
