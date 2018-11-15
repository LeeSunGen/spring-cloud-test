package com.itmuch.cloud.study.order.dao.impl;

import com.itmuch.cloud.study.common.util.Page;
import com.itmuch.cloud.study.common.util.PageUtil;
import com.itmuch.cloud.study.order.dao.OrderInfoDao;
import com.itmuch.cloud.study.order.dao.impl.mapper.OrderInfoMapper;
import com.itmuch.cloud.study.order.entity.OrderInfo;
import com.itmuch.cloud.study.order.entity.OrderInfoExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderInfoDaoImpl implements OrderInfoDao {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public int insert(OrderInfo record) {
        return this.orderInfoMapper.insert(record);
    }

    public int save(OrderInfo record) {
        return this.orderInfoMapper.insertSelective(record);
    }

    public int deleteByExample(OrderInfoExample example) {
        return this.orderInfoMapper.deleteByExample(example);
    }

    public int deleteById(Long id) {
        return this.orderInfoMapper.deleteByPrimaryKey(id);
    }

    public int updateById(OrderInfo record) {
        return this.orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OrderInfo record) {
        return this.orderInfoMapper.updateByPrimaryKey(record);
    }

    public int updateByExampleSelective(OrderInfo record, OrderInfoExample example) {
        return this.orderInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(OrderInfo record, OrderInfoExample example) {
        return this.orderInfoMapper.updateByExample(record, example);
    }

    public List<OrderInfo> listByExample(OrderInfoExample example) {
        return this.orderInfoMapper.selectByExample(example);
    }

    public OrderInfo getById(Long id) {
        return this.orderInfoMapper.selectByPrimaryKey(id);
    }

    public int countByExample(OrderInfoExample example) {
        return this.orderInfoMapper.countByExample(example);
    }

    public Page<OrderInfo> listForPage(int pageCurrent, int pageSize, OrderInfoExample example) {
        int count = this.orderInfoMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<OrderInfo>(count, totalPage, pageCurrent, pageSize, this.orderInfoMapper.selectByExample(example));
    }
}