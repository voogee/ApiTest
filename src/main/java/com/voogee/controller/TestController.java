package com.voogee.controller;


import com.voogee.bean.User;
import com.voogee.common.HttpUtils;
import com.voogee.common.JdbcTemplateUtils;
import com.voogee.config.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;


@Controller
@Scope("prototype")
@RequestMapping("test")
public class TestController {

    @Resource
    DataSource dataSource;
    //用于访问数据库的组件
    @Resource
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping(value = "/findByVo", method = {RequestMethod.GET,RequestMethod.POST})
    public ResultVo findByVo(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password) {
        String sql = "select * from users where username= %s and password= %s";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class,username,password);
        try {
            if (count ==1){
                return new ResultVo(0,"登录成功","");
            }
        } catch (Exception e){
            return new ResultVo(10001,"登录失败",e);

        }
        return new ResultVo(10001,"登录失败","");
    }

}


