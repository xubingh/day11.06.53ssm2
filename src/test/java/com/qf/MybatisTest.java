package com.qf;

import com.qf.entity.Account;
import com.qf.mappers.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private InputStream is;
    private SqlSession session;
    private AccountDao dao;

    @Before
    public void init() throws IOException {
        //读取配置文件
         is = Resources.getResourceAsStream("mybatis-config.xml");
        //实例化工厂类对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory对象
        SqlSessionFactory factory = builder.build(is);
//        创建sqlsession对象
         session = factory.openSession(true);
//        获取dao层代理类
         dao = session.getMapper(AccountDao.class);
    }
    @After
    public void destroy() throws IOException {
        session.close();
        is.close();
    }

    @Test
    public void demo(){
        List<Account> byall = dao.findByall();
        for (Account account : byall) {
            System.out.println(account);
        }
    }

    @Test
    public void demo2(){
        Account account = new Account();
        account.setName("大爷");
        account.setMoney(500d);
        /**
         * 执行sql语句\
         * 增删改需要提交事务
         */
        dao.saveAccount(account);
        session.commit();
    }
}
