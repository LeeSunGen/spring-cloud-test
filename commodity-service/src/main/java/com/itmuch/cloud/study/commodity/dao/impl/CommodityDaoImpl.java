package com.itmuch.cloud.study.commodity.dao.impl;

import com.itmuch.cloud.study.commodity.dao.CommodityDao;
import com.itmuch.cloud.study.commodity.dao.impl.mapper.CommodityMapper;
import com.itmuch.cloud.study.commodity.entity.Commodity;
import com.itmuch.cloud.study.commodity.entity.CommodityExample;
import com.itmuch.cloud.study.common.util.Page;
import com.itmuch.cloud.study.common.util.PageUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommodityDaoImpl implements CommodityDao {
    @Autowired
    private CommodityMapper commodityMapper;

    public int insert(Commodity record) {
        return this.commodityMapper.insert(record);
    }

    public int save(Commodity record) {
        return this.commodityMapper.insertSelective(record);
    }

    public int deleteByExample(CommodityExample example) {
        return this.commodityMapper.deleteByExample(example);
    }

    public int deleteById(Long id) {
        return this.commodityMapper.deleteByPrimaryKey(id);
    }

    public int updateById(Commodity record) {
        return this.commodityMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Commodity record) {
        return this.commodityMapper.updateByPrimaryKey(record);
    }

    public int updateByExampleSelective(Commodity record, CommodityExample example) {
        return this.commodityMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Commodity record, CommodityExample example) {
        return this.commodityMapper.updateByExample(record, example);
    }

    public List<Commodity> listByExample(CommodityExample example) {
        return this.commodityMapper.selectByExample(example);
    }

    public Commodity getById(Long id) {
        return this.commodityMapper.selectByPrimaryKey(id);
    }

    public int countByExample(CommodityExample example) {
        return this.commodityMapper.countByExample(example);
    }

    public Page<Commodity> listForPage(int pageCurrent, int pageSize, CommodityExample example) {
        int count = this.commodityMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<Commodity>(count, totalPage, pageCurrent, pageSize, this.commodityMapper.selectByExample(example));
    }
}