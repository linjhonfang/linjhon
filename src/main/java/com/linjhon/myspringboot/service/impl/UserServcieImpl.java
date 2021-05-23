package com.linjhon.myspringboot.service.impl;

import com.linjhon.myspringboot.service.UserService;

public class UserServcieImpl implements UserService{

    @Override
    public String getAllUsers() {
        return "{\"name\":\"linjhon2\"}";
    }
}
