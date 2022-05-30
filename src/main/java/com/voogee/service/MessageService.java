package com.voogee.service;

import com.voogee.bean.Message;
import com.voogee.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MessageService {

    public Message addmessage(String msgString);
    public List<User> getmessage(HttpServletRequest request);
}
