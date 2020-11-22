package com.min.tacocloud.service;

import com.min.tacocloud.entity.Taco;

public interface TacoService {

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
