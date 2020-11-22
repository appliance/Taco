package com.min.tacocloud.entity;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int id;

    /***
     *  订单名称
     */
    private String name;

    /***
     *  订单街道
     */
    private String street;

    /***
     *  城市
     */
    private String city;

    /***
     *  州
     */
    private String state;

    /***
     * 邮编
     */
    private String zip;

    /***
     * 信用卡
     */
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    /***
     * 订单日期
     */
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    /***
     *  visa cvv号
     */
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    /***
     * 入库日期
     */
    private Date placedAt;

    /***
     *
     * taco
     */
    private List<Taco> tacos;
}
