package com.min.tacocloud.service.impl;

import com.min.tacocloud.mapper.TacoIngredientMapper;
import com.min.tacocloud.service.TacoIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacoIngredientServiceImpl implements TacoIngredientService {

    @Autowired
    private TacoIngredientMapper tacoIngredientMapper;

    /***
     * 添加记录
     * @param tacoId
     * @param ingredientId
     */
    @Override
    public void addTacoIngredient(int tacoId, int ingredientId) {
        tacoIngredientMapper.addTacoIngredient(tacoId, ingredientId);
    }
}
