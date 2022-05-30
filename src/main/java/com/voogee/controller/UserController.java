package com.voogee.controller;

import com.alibaba.fastjson.JSONPObject;
import com.voogee.bean.User;
import com.voogee.mqtt.MyMqttClient;
import com.voogee.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.*;


@Controller
@Scope("prototype")
@RequestMapping("user")
public class UserController{
    @Resource
    UserService userService;

    @ResponseBody
    @PostMapping("user_login")
    public User user_login(User user, HttpServletRequest request){
        String parm = request.getParameter("username");
        System.out.println(parm);
        User loginUser = userService.login(user);
        System.out.println(loginUser);
        if(loginUser != null){
            return loginUser;
        }
        else{
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("user_all")
    public GenController user_all(HttpServletRequest request){
        List<User> userList = userService.getAllUser(request);
        GenController result = new GenController();
        Map userlist = new HashMap();
        userlist.put("userlist",userList);
        userlist.put("hasMore",0);
        result.setResponse(userlist);
        return result;

    }

}
