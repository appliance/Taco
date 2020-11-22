package com.min.tacocloud.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/***
 *
 *  配料类
 *
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final int id;
    private final String name;
    private final Type type;


    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
