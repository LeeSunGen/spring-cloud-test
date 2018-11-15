package com.itmuch.cloud.study.account.dao;

import com.itmuch.cloud.study.account.entity.Account;
import com.itmuch.cloud.study.account.entity.AccountExample;
import com.itmuch.cloud.study.common.util.Page;
import java.util.List;

public interface AccountDao {
    int insert(Account record);

    int save(Account record);

    int deleteByExample(AccountExample example);

    int deleteById(Long id);

    int updateById(Account record);

    int updateByPrimaryKey(Account record);

    int updateByExampleSelective(Account record, AccountExample example);

    int updateByExample(Account record, AccountExample example);

    Account getById(Long id);

    List<Account> listByExample(AccountExample example);

    int countByExample(AccountExample example);

    Page<Account> listForPage(int pageCurrent, int pageSize, AccountExample example);
}