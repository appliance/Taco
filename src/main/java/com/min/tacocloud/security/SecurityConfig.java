package com.min.tacocloud.security;

import com.min.tacocloud.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)     // 启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailServiceImpl userDetailService;

    /***
     * 通过覆盖该方法 用户存储提供验证方案
     * @param auth
     * @throws Exception
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 指定用户认证时，默认从 userDetailService中获取认证用户信息
        auth.userDetailsService(userDetailService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/design", "/orders").hasRole("USER").
                antMatchers("/", "/**").permitAll().
                and().
                formLogin().loginPage("/login");

    }

    /***
     * 密码加密器
     * @return
     */
    @Bean
    public PasswordEncoder encoder(){
        return new SCryptPasswordEncoder();
    }
}
