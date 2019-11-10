package com.linjhon.myspringboot.controller;

import com.linjhon.myspringboot.bo.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController("/")
public class UserController {


    @GetMapping("/user/get")
    public String getUserInfo() {
        return "zhangxueyou";
    }

    @RequestMapping("/redirect")
    public void redirect(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            writer.print("<html><head></head><body OnLoad=\"OnLoadEvent();\" ><form name='processing' ><div>正在导向联付通支付页面，请您稍后......</div></form><form name=\"downloadForm\" action=\"http://cashier.lianft.net:5888/payment\" method=\"POST\">  <input type=\"hidden\" name=\"merchantId\" value=\"15138236988255551165\">  <input type=\"hidden\" name=\"tradeId\" value=\"15403757685887264595\">  <input type=\"hidden\" name=\"channelId\" value=\"openapi\">  <input type=\"hidden\" name=\"publicTag\" value=\"false\"></form><SCRIPT LANGUAGE=\"Javascript\"> function OnLoadEvent(){ document.downloadForm.submit(); } </SCRIPT></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/mav")
    public ModelAndView mav(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("123");
        modelAndView.addObject("name", "flj");
        return modelAndView;
    }

    @PostMapping("/file/upload")
    public String upload(MultipartFile multipartFile, HttpServletRequest request) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String startTime = df.format(new Date());
        System.out.println(startTime);
        if (!multipartFile.isEmpty()) {
            //设置文件的保存路径
            try {
                String checkcode = DigestUtils.sha256Hex(multipartFile.getInputStream());
                String location = "C:\\test\\" + checkcode + File.separator+multipartFile.getOriginalFilename();
           /*  File file = new File(location);
            if(!file.exists()){
                file.mkdirs();
            }
            String filePath = location + multipartFile.getOriginalFilename();
            System.out.println(filePath);
            //转存文件
                multipartFile.transferTo(new File(filePath));*/
                //4M 1024 * 1024 * 4*10
                try {
                    File fileTemp = new File(location);
                    File parent = fileTemp.getParentFile();
                    if (!parent.exists()) parent.mkdirs();
                    if (!fileTemp.exists()) fileTemp.createNewFile();
                    //写入
                    multipartFile.transferTo(fileTemp);
                }catch (Exception e){
                    e.printStackTrace();
                }
//                write(location, multipartFile.getBytes(), 41943040);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String endTime = df.format(new Date());
        System.out.println(endTime);
        return startTime + "->" + endTime;
    }

        public static void write(String file, byte[] bytes, Integer bufferSize) {

        ByteBuffer buf = ByteBuffer.allocate(bufferSize);
        FileChannel channel = null;
        try {
            File fileTemp = new File(file);
            File parent = fileTemp.getParentFile();
            if (!parent.exists()) parent.mkdirs();
            if (!fileTemp.exists()) fileTemp.createNewFile();

            // new FileOutputStream(file, append)  第二个参数为true表示追加写入
            channel = new FileOutputStream(file, true).getChannel();

            buf.put(bytes);
            buf.flip();   // 切换为读模式

            while (buf.hasRemaining()) {
                channel.write(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
