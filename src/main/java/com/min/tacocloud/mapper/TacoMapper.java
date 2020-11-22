package com.min.tacocloud.mapper;

import com.min.tacocloud.entity.Taco;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TacoMapper {
    /***
     * 插入新录入Taco记录
     * @param taco
     */
    public void addTaco(Taco taco);

    /***
     * 依据tacoName查询id
     * @param tacoName
     * @return
     */
    public int findIdByName(String tacoName);


}
