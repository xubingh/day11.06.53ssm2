package com.qf.service;

import com.qf.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findByall();

    /**
     * // 保存帐户信息
     */
    void saveAccount(Account account);
}
