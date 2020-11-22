package com.min.tacocloud.service.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author: jc
 * @date: 2020/11/20 21:34
 * @description: 用于存储 请求资源 和 用户关系之间的关系
 */
@Component
public class InvocationSecurityMetadataSourceServiceImpl implements FilterInvocationSecurityMetadataSource {

    // TODO: 获取请求资源 + 权限

    /***
     *
     * 资源-角色
     */
    private static HashMap<String, Collection<ConfigAttribute>> map = null;

    /***
     * 接受http请求时 filterSecurityInterceptor会调用该方法，参数Object是一个包含url的HttpServletRequest实例
     * 返回请求资源对应的角色权限集合
     *
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(null == map){
            // TODO: 初始化 资源 对应角色
            loadResourceDefine();
        }
        // 参数 object中包含用户请求的request信息
        HttpServletRequest request = ((FilterInvocation) o).getRequest();
        Iterable<String> urlList = map.keySet();
        for(String url : urlList){
            if(new AntPathRequestMatcher(url).matches(request)){
                return map.get(url);
            }
        }
        return null;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    /***
     *
     *  初始化 请求资源 对应的角色
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        // USER 角色
        ConfigAttribute admin_role = new SecurityConfig("ADMIN");
        ConfigAttribute user_role = new SecurityConfig("USER");

        // "/design" 角色权限
        List<ConfigAttribute> design_roles = new ArrayList<>();
        design_roles.add(admin_role);
        design_roles.add(user_role);

        // “/order” 角色权限
        List<ConfigAttribute> order_roles = new ArrayList<>();
        order_roles.add(admin_role);

        map.put("/design", design_roles);
        map.put("/order", order_roles);

    }
}
