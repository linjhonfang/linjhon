package com.linjhon.myspringboot;

import com.linjhon.myspringboot.service.UserService;
import com.linjhon.myspringboot.service.impl.UserServcieImpl;

public class MyTest {
    public static void main(String[] args) {

        UserService userService = new UserServcieImpl();
    }

}
