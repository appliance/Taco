package com.min.tacocloud.service.impl;

import com.min.tacocloud.entity.TacoUser;
import com.min.tacocloud.entity.Role;
import com.min.tacocloud.mapper.RoleMapper;
import com.min.tacocloud.mapper.TacoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 配置用户认证
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TacoUserMapper tacoUserMapper;

    @Autowired
    private RoleMapper roleMapper;


    /***
     * 根据用户名称 封装 认证用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TacoUser tacoUser = tacoUserMapper.findUserByName(username);
        List<Role> roles = roleMapper.findRolesByUsername(username);
        if(tacoUser != null){
            tacoUser.setAuthorities(roles);
            return tacoUser;
        }
        throw  new UsernameNotFoundException("User: " + username + "not found");
    }




}
