package com.min.tacocloud.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    private String name;

    private String nameZh;

    @Override
    public String getAuthority() {
        return name;
    }
}
