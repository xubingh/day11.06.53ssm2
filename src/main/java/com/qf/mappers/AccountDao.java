package com.qf.mappers;

import com.qf.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
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
