package com.min.tacocloud.controller;

import com.min.tacocloud.entity.TacoUser;
import com.min.tacocloud.formEntity.UserForm;
import com.min.tacocloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(UserForm userForm){
        // TODO: 获取用户名密码进行验证
        TacoUser TacoUser = userService.findUserByName(userForm.getUsername());
        if(passwordEncoder.matches(userForm.getPassword(), TacoUser.getPassword())){
            return "redirect:/design";
        }else{
            return "login";
        }

    }

}
