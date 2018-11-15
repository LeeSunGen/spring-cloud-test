package com.itmuch.cloud.study.payment.dao.impl;

import com.itmuch.cloud.study.common.util.Page;
import com.itmuch.cloud.study.common.util.PageUtil;
import com.itmuch.cloud.study.payment.dao.PaymentDao;
import com.itmuch.cloud.study.payment.dao.impl.mapper.PaymentMapper;
import com.itmuch.cloud.study.payment.entity.Payment;
import com.itmuch.cloud.study.payment.entity.PaymentExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao {
    @Autowired
    private PaymentMapper paymentMapper;

    public int insert(Payment record) {
        return this.paymentMapper.insert(record);
    }

    public int save(Payment record) {
        return this.paymentMapper.insertSelective(record);
    }

    public int deleteByExample(PaymentExample example) {
        return this.paymentMapper.deleteByExample(example);
    }

    public int deleteById(Long id) {
        return this.paymentMapper.deleteByPrimaryKey(id);
    }

    public int updateById(Payment record) {
        return this.paymentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Payment record) {
        return this.paymentMapper.updateByPrimaryKey(record);
    }

    public int updateByExampleSelective(Payment record, PaymentExample example) {
        return this.paymentMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Payment record, PaymentExample example) {
        return this.paymentMapper.updateByExample(record, example);
    }

    public List<Payment> listByExample(PaymentExample example) {
        return this.paymentMapper.selectByExample(example);
    }

    public Payment getById(Long id) {
        return this.paymentMapper.selectByPrimaryKey(id);
    }

    public int countByExample(PaymentExample example) {
        return this.paymentMapper.countByExample(example);
    }

    public Page<Payment> listForPage(int pageCurrent, int pageSize, PaymentExample example) {
        int count = this.paymentMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<Payment>(count, totalPage, pageCurrent, pageSize, this.paymentMapper.selectByExample(example));
    }
}