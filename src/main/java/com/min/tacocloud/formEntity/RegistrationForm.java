package com.min.tacocloud.formEntity;

import com.min.tacocloud.entity.TacoUser;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: jc
 * @date: 2020/11/18 14:37
 * @description:
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    /***
     * RegistrationForm转化为User
     * @return
     */
    public TacoUser toUser(PasswordEncoder passwordEncoder){
        TacoUser tacoUser = new TacoUser();
        tacoUser.setUsername(username);
        tacoUser.setPassword(passwordEncoder.encode(password));
        tacoUser.setFullname(fullname);
        tacoUser.setStreet(street);
        tacoUser.setCity(city);
        tacoUser.setState(state);
        tacoUser.setZip(zip);
        tacoUser.setPhoneNumber(phone);
        return tacoUser;
    }
}
