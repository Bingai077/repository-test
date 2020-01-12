package com.bingai.controller;

import com.bingai.domain.Account;
import com.bingai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**账户web
 * @author bingai
 * @create 2019-12-25 12:16
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户");

        //调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);

        return "list";
    }

    /**
     * 保存
     * @param account
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {

        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");

        return ;
    }

}
