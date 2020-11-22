package com.min.tacocloud.mapper;

import com.min.tacocloud.entity.TacoUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TacoUserMapper {

    /***
     * 查询所有用户
     * @return
     */
    List<TacoUser> findAllUsers();


    /***
     * 依据用户名称查询用户
     * @param userName
     * @return
     */
    TacoUser findUserByName(String userName);

    /***
     * 插入用户
     * @param TacoUser
     * @return
     */
    void addUser(TacoUser TacoUser);



}
