package com.qf.service.impl;

import com.qf.entity.Account;
import com.qf.mappers.AccountDao;
import com.qf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    /**\
     * spring结合mybatis整合完毕之后开启实现业务层
     */
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findByall() {
        System.out.println("业务层:查询所有账户");
        List<Account> list = accountDao.findByall();

        return list;
//        return accountDao.findByall();

    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层:查询增加账户");
         accountDao.saveAccount(account);
    }
}
