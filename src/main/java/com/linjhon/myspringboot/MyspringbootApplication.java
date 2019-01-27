package com.linjhon.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyspringbootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("{\"users\":[{\"name\":\"linjhon\"},{\"name\":\"zhangsan\"}]}");
		System.out.println("main starting...");
		SpringApplication.run(MyspringbootApplication.class, args);
	}
}
