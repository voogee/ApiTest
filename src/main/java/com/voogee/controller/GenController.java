package com.voogee.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class GenController {

    private int code = 0;
    private String msg ="成功";


    private Map response = new HashMap();

    public GenController() {
        this.code = code;
        this.msg = msg;
        this.response = response;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map getResponse() {
        return response;
    }

    public void setResponse(Map response) {
        this.response = response;
    }
}

