package com.itmuch.cloud.study.account.dao.impl;

import com.itmuch.cloud.study.account.entity.Account;
import com.itmuch.cloud.study.account.dao.AccountDao;
import com.itmuch.cloud.study.account.dao.impl.mapper.AccountMapper;
import com.itmuch.cloud.study.account.entity.AccountExample;
import com.itmuch.cloud.study.common.util.Page;
import com.itmuch.cloud.study.common.util.PageUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private AccountMapper accountMapper;

    public int insert(Account record) {
        return this.accountMapper.insert(record);
    }

    public int save(Account record) {
        return this.accountMapper.insertSelective(record);
    }

    public int deleteByExample(AccountExample example) {
        return this.accountMapper.deleteByExample(example);
    }

    public int deleteById(Long id) {
        return this.accountMapper.deleteByPrimaryKey(id);
    }

    public int updateById(Account record) {
        return this.accountMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Account record) {
        return this.accountMapper.updateByPrimaryKey(record);
    }

    public int updateByExampleSelective(Account record, AccountExample example) {
        return this.accountMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Account record, AccountExample example) {
        return this.accountMapper.updateByExample(record, example);
    }

    public List<Account> listByExample(AccountExample example) {
        return this.accountMapper.selectByExample(example);
    }

    public Account getById(Long id) {
        return this.accountMapper.selectByPrimaryKey(id);
    }

    public int countByExample(AccountExample example) {
        return this.accountMapper.countByExample(example);
    }

    public Page<Account> listForPage(int pageCurrent, int pageSize, AccountExample example) {
        int count = this.accountMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<Account>(count, totalPage, pageCurrent, pageSize, this.accountMapper.selectByExample(example));
    }
}