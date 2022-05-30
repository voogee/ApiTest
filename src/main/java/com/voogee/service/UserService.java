package com.voogee.service;

import com.voogee.bean.User;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    public User login(User user);
    public List<User> getAllUser(HttpServletRequest request);

}
