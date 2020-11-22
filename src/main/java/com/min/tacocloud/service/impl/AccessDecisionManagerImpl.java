package com.min.tacocloud.service.impl;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author: jc
 * @date: 2020/11/21 19:51
 * @description:
 */
@Component
public class AccessDecisionManagerImpl implements AccessDecisionManager {

    /***
     * 通过传递过来的参数，确定用户是否有访问权限
     * @param authentication 用户信息 （ 登录时 UserDetailsService中设置的authorities
     * @param o FilterInvocation对象，可以得到request等web资源
     * @param collection 本次访问需要的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        // 访问该路径不需要权限
        if(null == collection || 0 >= collection.size()){
            return;
        }else{
            String needRole;
            for(Iterator<ConfigAttribute> iter = collection.iterator(); iter.hasNext(); ){
                needRole = iter.next().getAttribute();

                for(GrantedAuthority authority : authentication.getAuthorities()){
                    if(needRole.trim().equals(authority.getAuthority().trim())){
                        return;
                    }
                }
            }
            throw new AccessDeniedException("Current user has no authority");
        }

    }

    /***
     *
     * AccessDecisionManagerImpl 是否能够处理传递的ConfigAttribute呈现的授权请求
     * @param configAttribute
     * @return
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
