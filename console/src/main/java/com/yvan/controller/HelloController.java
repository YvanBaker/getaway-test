package com.yvan.controller;

import com.alibaba.fastjson.JSON;
import com.yvan.utils.HttpClientEngine;
import com.yvan.utils.RequestEntity;
import com.yvan.vo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author v_yangfeng01
 * @date 2021/2/18
 */
@RestController
@RequestMapping("/gateway")
public class HelloController {

    @PostMapping("/hello")
    public String hello(HttpServletRequest request) {
        String header = request.getHeader("X-test");
        return "hello " + header;
    }

    @PostMapping("/test")
    public String test(String s){
        User user = new User();
        user.setName("123");
        user.setAge(123);
        return JSON.toJSONString(user);
    }

    public String post(){
        HttpClientEngine httpClientEngine = new HttpClientEngine();
        RequestEntity requestEntity = new RequestEntity();
        Map<Object,Object> queryParams = new HashMap<>();
        Map<Object,Object> bodyParams = new HashMap<>();
        Map<Object,Object> headerParams = new HashMap<>();
        queryParams.put("access_token", "24.f388ac85c11f12993dc048515dd70951.2592000.1617120000.282335-23116975");
        bodyParams.put("recognize_granularity", "small");
        bodyParams.put("detect_direction","false");
        bodyParams.put("image","123");
        headerParams.put("Content-Type", "application/x-www-form-urlencoded");
        requestEntity.setRequestParams();
        return "123";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        String tset = request.getParameter("token");
        String fileName = file.getOriginalFilename();
        String filePath = "/Users/v_yangfeng01/temp/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
        }
        return "上传失败！";
    }
}
