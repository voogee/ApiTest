package com.voogee.controller;


import com.voogee.common.HttpUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("prototype")
@RequestMapping("test")
public class TestController {
    @ResponseBody
    @RequestMapping("test")
    public String test(HttpServletRequest request){
        String r=  HttpUtils.sendHttpGet("https://api8.soyoung.com/v8/misc/abtest");
        
        return r;
    }

}
