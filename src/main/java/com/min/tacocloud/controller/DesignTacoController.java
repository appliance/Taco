package com.min.tacocloud.controller;


import com.min.tacocloud.entity.Ingredient;
import com.min.tacocloud.entity.Taco;
import com.min.tacocloud.formEntity.TacoForm;
import com.min.tacocloud.service.IngredientService;
import com.min.tacocloud.service.TacoIngredientService;
import com.min.tacocloud.service.TacoService;
import com.min.tacocloud.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j   // simple logging facade for java 添加日志
@Controller
@RequestMapping
public class DesignTacoController{


    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private TacoService tacoService;

    @Autowired
    private TacoIngredientService tacoIngredientService;



    @GetMapping("/design")  // /design的get请求
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = ingredientService.findAll();

        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        return "design";

    }

    // @Valid 校验时间 实在Taco绑定完表单数据之后， 调用ProcessDesign()之前
    @PostMapping("/design")
    public String processDesign(@Valid TacoForm tacoForm, Errors errors, Model model){

        if(errors.hasErrors()){
            // 入参，验证失败
            System.out.println("validation failed");
            System.out.println(errors.getAllErrors());
            List<Ingredient> ingredients = ingredientService.findAll();

            Ingredient.Type[] types = Ingredient.Type.values();
            for(Ingredient.Type type : types){
                model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
            }

            return "design";
        } else {
            // 入参，验证成功
            Taco taco = new Taco();
            taco.setName(tacoForm.getTacoName());

            taco.setCreatedAt(DateUtil.getCurrentDate());

            // step1：保存该taco记录
            tacoService.addTaco(taco);

            // step2: 获取taco id 获取ingredient id 关联保存到 taco_ingredient table中
            int tacoId = taco.getId();

            // step3: 获取id
            for(String ingredientId : tacoForm.getIngredients()){
                tacoIngredientService.addTacoIngredient(tacoId, Integer.parseInt(ingredientId));
            }

            return "redirect:/orders/current";
        }


    }

    /***
     *  lambda编程
     *  按类型过滤 返回集合
     */
    private List<Ingredient> filterByType(List<Ingredient> lists, Ingredient.Type type){
        return lists.stream().filter(x -> type.equals(x.getType())).collect(Collectors.toList());
    }

}
