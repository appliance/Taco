package com.min.tacocloud.controller;

import com.min.tacocloud.formEntity.RegistrationForm;
import com.min.tacocloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: jc
 * @date: 2020/11/18 11:35
 * @description: 用户注册
 */
@Controller
@RequestMapping("/register")
public class RegistractionController {
    @Autowired
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm(){
        return "register";
    }

    @PostMapping
    public String processRegisteration(RegistrationForm registrationForm){
        //TODO: save user detail info
        userService.addUser(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
