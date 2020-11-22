package com.min.tacocloud.mapper;

import com.min.tacocloud.entity.Role;

import java.util.List;

public interface RoleMapper {

    /***
     * 根据用户查询用户权限
     * @param username
     * @return
     */
    List<Role> findRolesByUsername(String username);

}
