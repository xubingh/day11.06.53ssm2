package com.qf.controller;

import com.qf.entity.Account;
import com.qf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * controller联系前端
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**mvc+spring
     *Model : 前端页面展示
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层:查询所有账户");
        List<Account> accountList = accountService.findByall();
        model.addAttribute("list",accountList);
        /**
         * 旋转视图
         */
        return "list";
    }


    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletResponse response,
                            HttpServletRequest request) throws IOException {
        System.out.println("表现层:保存账户");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
//        return "account";
        return;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Account> getList(){
        System.out.println("返回json格式的字符串");
        List<Account> byall = accountService.findByall();
        return byall;
    }

}
