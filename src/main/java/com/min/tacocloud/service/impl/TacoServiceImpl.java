package com.min.tacocloud.service.impl;

import com.min.tacocloud.entity.Taco;
import com.min.tacocloud.mapper.TacoMapper;
import com.min.tacocloud.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImpl implements TacoService {

    @Autowired
    private TacoMapper tacoMapper;

    /***
     * 插入新录入Taco记录
     * @param taco
     */
    @Override
    public void addTaco(Taco taco) {
        tacoMapper.addTaco(taco);
    }


    /***
     * 依据tacoName查询id
     * @param tacoName
     * @return
     */
    public int findIdByName(String tacoName){
        int id = tacoMapper.findIdByName(tacoName);
        return id;
    }
}
