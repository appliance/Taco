package com.min.tacocloud.service.impl;


import com.min.tacocloud.entity.TacoUser;
import com.min.tacocloud.mapper.TacoUserMapper;
import com.min.tacocloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TacoUserMapper tacoUserMapper;

    /***
     * 添加用户
     * @param TacoUser
     * @return
     */
    @Override
    public void addUser(TacoUser TacoUser) {
        tacoUserMapper.addUser(TacoUser);
    }

    /***
     * 获取用户
     * @param username
     * @return
     */
    @Override
    public TacoUser findUserByName(String username) {
        return tacoUserMapper.findUserByName(username);
    }
}
