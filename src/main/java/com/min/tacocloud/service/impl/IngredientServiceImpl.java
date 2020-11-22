package com.min.tacocloud.service.impl;

import com.min.tacocloud.entity.Ingredient;
import com.min.tacocloud.mapper.IngredientMapper;
import com.min.tacocloud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientMapper ingredientMapper;

    /***
     *
     * 检索全部配料
     * @return
     */
    @Override
    public List<Ingredient> findAll() {
        return ingredientMapper.findAll();
    }
}
