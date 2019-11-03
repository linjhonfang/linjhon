package com.linjhon.myspringboot;

import com.linjhon.myspringboot.service.UserService;
import com.linjhon.myspringboot.service.impl.UserServcieImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {
   private static Logger logger = LoggerFactory.getLogger(MyTest.class);
    public static void main(String[] args) {
        System.out.println("write in springboot-1221");
        System.out.println("write in springboot-20190303");
        UserService userService = new UserServcieImpl();
        logger.debug("finish");
    }

}
