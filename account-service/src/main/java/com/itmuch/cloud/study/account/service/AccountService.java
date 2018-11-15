package com.itmuch.cloud.study.account.service;

import com.itmuch.cloud.study.account.bean.AccountQO;
import com.itmuch.cloud.study.account.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> queryForList(AccountQO qo);

    int updateByExampleSelective(AccountQO qo);
}
