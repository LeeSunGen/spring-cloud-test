package com.itmuch.cloud.study.account.service.impl;

import com.itmuch.cloud.study.account.bean.AccountQO;
import com.itmuch.cloud.study.account.dao.AccountDao;
import com.itmuch.cloud.study.account.entity.Account;
import com.itmuch.cloud.study.account.entity.AccountExample;
import com.itmuch.cloud.study.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> queryForList(AccountQO qo){
        AccountExample example = new AccountExample();
        example.setOrderByClause("id desc");
        AccountExample.Criteria c = example.createCriteria();
        if(qo.getUserId() != null){
            c.andUserIdEqualTo(qo.getUserId());
        }
        return accountDao.listByExample(example);
    }

    @Override
    public int updateByExampleSelective(AccountQO qo) {
         Account account = new Account();
         if(qo.getUserId() != null){
             account.setUserId(qo.getUserId());
         }
         if(qo.getTotalAmount() != null){
             account.setAccountBalance(qo.getTotalAmount());
         }
         AccountExample example = new AccountExample();
         example.setOrderByClause("id desc");
         AccountExample.Criteria c = example.createCriteria();
         if(qo.getUserId() != null){
             c.andUserIdEqualTo(qo.getUserId());
         }
        return accountDao.updateByExampleSelective(account,example);
    }


}
