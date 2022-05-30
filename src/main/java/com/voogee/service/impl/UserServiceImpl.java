package com.voogee.service.impl;

import com.alibaba.fastjson.JSONPObject;
import com.voogee.bean.User;
import com.voogee.mapper.UserMapper;
import com.voogee.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserMapper userMapper;

    @Override
    public User login(User user){
        return userMapper.login(user);
    }

    @Override
    public List<User> getAllUser(HttpServletRequest request) {
        String query = request.getQueryString();
        if(query == null){
            return null;
        }
        if(!query.contains("type")){
            return null;
        }
        String type = request.getParameter("type");
        if(type.equals("1")){
            return userMapper.getAllUser();
        }else {
            return null;
        }
    }
}
