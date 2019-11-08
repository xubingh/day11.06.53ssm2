package com.qf;



import com.qf.entity.Account;
import com.qf.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {
    @Test
    public void run(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
        // 获取对象
        AccountService as = (AccountService) ac.getBean("accountService",AccountService.class);
        // 调用方法
        as.findByall();
    }
}
