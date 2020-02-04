package com.zahuopu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.pojo.system.Admin;
import com.zahuopu.service.system.AdminService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-16 11:46
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Reference
    private AdminService adminService;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("经过userDetailService。。。。。");

        Map map = new HashMap<>();
        map.put("loginName",username);
        map.put("status",1);
        List<Admin> list = adminService.findList(map);
        if(list.size()==0){
            return  null;
        }

        //实际项目中应该从数据库中提取用户的角色列表
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(username,list.get(0).getPassword(),grantedAuthorities);

    }
}
