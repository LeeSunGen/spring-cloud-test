package com.itmuch.cloud.study.order.dao;

import com.itmuch.cloud.study.common.util.Page;
import com.itmuch.cloud.study.order.entity.OrderInfo;
import com.itmuch.cloud.study.order.entity.OrderInfoExample;
import java.util.List;

public interface OrderInfoDao {
    int insert(OrderInfo record);

    int save(OrderInfo record);

    int deleteByExample(OrderInfoExample example);

    int deleteById(Long id);

    int updateById(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int updateByExampleSelective(OrderInfo record, OrderInfoExample example);

    int updateByExample(OrderInfo record, OrderInfoExample example);

    OrderInfo getById(Long id);

    List<OrderInfo> listByExample(OrderInfoExample example);

    int countByExample(OrderInfoExample example);

    Page<OrderInfo> listForPage(int pageCurrent, int pageSize, OrderInfoExample example);
}