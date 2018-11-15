package com.itmuch.cloud.study.commodity.dao;

import com.itmuch.cloud.study.commodity.entity.Commodity;
import com.itmuch.cloud.study.commodity.entity.CommodityExample;
import com.itmuch.cloud.study.common.util.Page;
import java.util.List;

public interface CommodityDao {
    int insert(Commodity record);

    int save(Commodity record);

    int deleteByExample(CommodityExample example);

    int deleteById(Long id);

    int updateById(Commodity record);

    int updateByPrimaryKey(Commodity record);

    int updateByExampleSelective(Commodity record, CommodityExample example);

    int updateByExample(Commodity record, CommodityExample example);

    Commodity getById(Long id);

    List<Commodity> listByExample(CommodityExample example);

    int countByExample(CommodityExample example);

    Page<Commodity> listForPage(int pageCurrent, int pageSize, CommodityExample example);
}