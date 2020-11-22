package com.min.tacocloud.service;


import com.min.tacocloud.entity.TacoUser;

public interface UserService {

    /***
     * 添加用户
     * @param TacoUser
     * @return
     */
    void addUser(TacoUser TacoUser);

    /***
     * 获取用户详情信息
     * @param username
     * @return
     */
    TacoUser findUserByName(String username);


}
