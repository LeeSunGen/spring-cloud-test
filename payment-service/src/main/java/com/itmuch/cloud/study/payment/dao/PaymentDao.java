package com.itmuch.cloud.study.payment.dao;

import com.itmuch.cloud.study.common.util.Page;
import com.itmuch.cloud.study.payment.entity.Payment;
import com.itmuch.cloud.study.payment.entity.PaymentExample;
import java.util.List;

public interface PaymentDao {
    int insert(Payment record);

    int save(Payment record);

    int deleteByExample(PaymentExample example);

    int deleteById(Long id);

    int updateById(Payment record);

    int updateByPrimaryKey(Payment record);

    int updateByExampleSelective(Payment record, PaymentExample example);

    int updateByExample(Payment record, PaymentExample example);

    Payment getById(Long id);

    List<Payment> listByExample(PaymentExample example);

    int countByExample(PaymentExample example);

    Page<Payment> listForPage(int pageCurrent, int pageSize, PaymentExample example);
}