package com.min.tacocloud.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TacoIngredientMapper {

    /***
     * 添加Taco及Ingredient关联记录
     * @param tacoId
     * @param ingredientId
     */
    void addTacoIngredient(int tacoId, int ingredientId);
}
