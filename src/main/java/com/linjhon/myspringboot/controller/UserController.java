package com.linjhon.myspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@RestController("/")
public class UserController {

    @GetMapping("/user/get")
    public String getUserInfo(){

        return "zhangxueyou";
    }

    @RequestMapping("/redirect")
    public  void redirect(HttpServletRequest request,HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
             writer.print("<html><head></head><body OnLoad=\"OnLoadEvent();\" ><form name='processing' ><div>正在导向联付通支付页面，请您稍后......</div></form><form name=\"downloadForm\" action=\"http://cashier.lianft.net:5888/payment\" method=\"POST\">  <input type=\"hidden\" name=\"merchantId\" value=\"15138236988255551165\">  <input type=\"hidden\" name=\"tradeId\" value=\"15403757685887264595\">  <input type=\"hidden\" name=\"channelId\" value=\"openapi\">  <input type=\"hidden\" name=\"publicTag\" value=\"false\"></form><SCRIPT LANGUAGE=\"Javascript\"> function OnLoadEvent(){ document.downloadForm.submit(); } </SCRIPT></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/mav")
    public ModelAndView mav(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.addObject("123");
        modelAndView.addObject("name","flj");
        return modelAndView;
    }
}
