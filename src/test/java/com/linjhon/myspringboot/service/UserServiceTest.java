package com.linjhon.myspringboot.service;

import com.linjhon.myspringboot.MyspringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyspringbootApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers(){
        System.out.println(userService.getAllUsers());
    }
}