package com.min.tacocloud.mapper;

import com.min.tacocloud.entity.Ingredient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IngredientMapper {

    /***
     *
     * 检索全部配料
     * @return
     */
    List<Ingredient> findAll();


}
