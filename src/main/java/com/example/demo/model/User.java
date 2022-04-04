package com.example.demo.model;

import lombok.Data;

/**
 * @Date 2022/4/4 10:47
 * @Created by ltc
 */
@Data
public class User {

    private String username;

    private Integer age;

    private Bank bank;
}
