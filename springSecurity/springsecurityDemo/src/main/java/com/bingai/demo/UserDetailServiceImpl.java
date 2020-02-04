package com.bingai.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bingai
 * @create 2020-01-16 11:46
 */
public class UserDetailServiceImpl implements UserDetailsService {


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("经过userDetailService。。。。。");
        //实际项目中应该从数据库中提取用户的角色列表
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(username,"$2a$10$ZEhPGoAiNpyHVQwMrSVYf.REN8J0tQ/CjKKSwqghZUwrxsnLS0e5O",grantedAuthorities);
    }
}
