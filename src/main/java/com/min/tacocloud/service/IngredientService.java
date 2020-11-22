package com.min.tacocloud.service;

import com.min.tacocloud.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    /***
     *
     * 检索全部配料
     * @return
     */
    List<Ingredient> findAll();

}
