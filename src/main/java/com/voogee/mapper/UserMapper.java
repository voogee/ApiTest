package com.voogee.mapper;

import com.voogee.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User login(User user);
    public List<User> getAllUser();

}
