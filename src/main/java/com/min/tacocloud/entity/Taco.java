package com.min.tacocloud.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
    /***
     * id
     */
    private int id;

    /***
     *  塔克名称
     */
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;


    @Size(min = 1, message = "At least choice one ingredient")
    private List<Ingredient> ingredients;

    /***
     *
     *  创建时间
     */
    private String createdAt;

}
