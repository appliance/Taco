package com.min.tacocloud.formEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *
 *  orderForm 接受Form表单提交信息实体
 */
@Data
public class TacoForm {
    /***
     * taco 提交名称
     */
    @NotBlank(message = "taco name must be input")
    private String tacoName;

    /***
     * taco 集合 id
     */
    @NotNull(message = "at least one ingredient must be choiced")
    @Size(min = 1, message = "at least one ingredient must be choiced")
    private String[] ingredients;

}
