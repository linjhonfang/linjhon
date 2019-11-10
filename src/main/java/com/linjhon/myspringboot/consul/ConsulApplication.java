//package com.linjhon.myspringboot.consul;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@SpringBootApplication
//@EnableDiscoveryClient
//@RestController
//public class ConsulApplication {
//    Logger logger = LoggerFactory.getLogger(ConsulApplication.class);
//    @GetMapping("/")
//    public String home(){
//        return "Hello World";
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(ConsulApplication.class);
//    }
//}
