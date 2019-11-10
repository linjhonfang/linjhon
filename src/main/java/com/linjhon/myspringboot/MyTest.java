package com.linjhon.myspringboot;

import com.linjhon.myspringboot.service.UserService;
import com.linjhon.myspringboot.service.impl.UserServcieImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.FileHandler;

public class MyTest {
   private static Logger logger = LoggerFactory.getLogger(MyTest.class);
    public static void main(String[] args) {
//        System.out.println("write in springboot-1221");
//        System.out.println("write in springboot-20190303");
//        UserService userService = new UserServcieImpl();
//        logger.debug("finish");
        try {
//            File file = new File("D:\\test\\myTest.go");
            File file = new File("C:\\test\\08b9c5563c35200e4661ea8eae9ae4043b0f69986640a2e608d9a76ff96361aa\\pycharm-professional-2019.1.1.exe");
            FileInputStream fileInputStream = new FileInputStream(file);
            String s = DigestUtils.sha256Hex(fileInputStream);
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
