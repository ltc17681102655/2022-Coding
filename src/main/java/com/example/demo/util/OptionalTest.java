package com.example.demo.util;

import com.example.demo.model.Bank;
import com.example.demo.model.User;

import java.util.Optional;

/**
 * @Date 2022/4/4 10:46
 * @Created by ltc
 */

public class OptionalTest {
    public static void main(String[] args) {
        User user = null;
        Bank bank = Optional.ofNullable(user)
                .map(x -> x.getBank())
                .orElseThrow(() -> new RuntimeException("不存在值"));
        System.out.println(bank);
    }

    public static void orElseThrow() {
        String value = null;
        String orElse = Optional.ofNullable(value).orElseThrow(() -> new RuntimeException("不存在值"));
        System.out.println(orElse);
    }

    public static void flatMap() {
        User user = new User();
        user.setUsername("我是小四哥");
        user.setAge(20);
        Optional<String> optional = Optional.ofNullable(user).flatMap(OptionalTest::getFlatMap);
        System.out.println(optional);
    }

    public static Optional<String> getFlatMap(User user) {
        return Optional.ofNullable(user).map(User::getUsername);
    }


    /**
     * 参数传入一个对象，返回一个Option对象，value不能为空，如果为null，将抛出空指针异常
     */
    public static void ofValue() {
        User user = null;
        Optional<User> optional = Optional.of(user);
        System.out.println(optional);
    }

    /**
     * 参数传入一个对象，可以为空，如果为空，将返回一个空的Optional对象，就等于Optional.empty()，输出的值为Optional.empty,
     * 如果不为空，返回一个不为空的Optional对象
     */
    public static void ofNullable() {
        User user = null;
        Optional<User> optional = Optional.ofNullable(user);
        System.out.println(optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
    }

    public static void isPresent() {
        User user = new User();
        user.setUsername("abc");
        Optional<User> optional = Optional.ofNullable(user);
        Optional<User> optionalUser = optional.filter(x -> x.getUsername().equals("abc"));
        System.out.println(optionalUser);
    }
}
