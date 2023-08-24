package com.voogee.controller;

import com.alibaba.fastjson.JSONPObject;
import com.voogee.bean.User;
//import com.voogee.mqtt.MyMqttClient;
import com.voogee.mapper.UserMapper;
import com.voogee.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.*;

/**
 * 用户分组
 * 用户相关的接口
 *
 */


@CrossOrigin
@Controller
@Scope("prototype")
@RequestMapping("user")
public class UserController{
    @Resource
    UserService userService;

    @Resource
    private UserMapper usermapper;

    /**
     * 用户登录
     * 用户登录
     * @param
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/user_login",method = {RequestMethod.GET,RequestMethod.POST})
    public GenController user_login(User user, HttpServletRequest request){
        GenController result = new GenController();
        User loginUser = userService.login(user);
        Map usermap = new HashMap();
        usermap.put("userinfo",loginUser);
        result.setResponse(usermap);
        if(loginUser != null){
            return result;
        }
        else{
            result.setCode(10001);
            result.setMsg("账号或密码错误");
            return result;
        }

    }

    @ResponseBody
    @RequestMapping("user_find")
    public User user_find(User user, HttpServletRequest request){
        String username = request.getParameter("username");
        System.out.println(username);
        User loginUser = usermapper.selone(username);
        System.out.println(loginUser);
        if(loginUser != null){
            return loginUser;
        }
        else{
            return null;
        }

    }


}
