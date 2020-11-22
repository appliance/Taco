package com.min.tacocloud.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
public class TacoUser implements UserDetails {

    private int id;
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    // Role 实现接口 GrantedAuthority
    private List<Role> authorities;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    // 用户账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //  用户账号是被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 用户密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 用户是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
