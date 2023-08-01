package com.voogee.mapper;

import com.voogee.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public User login(User user);
    public List<User> getAllUser();

    //mapper传参两种方式，不指定参数名xml则用#{下标获取}
//    public User selone(@Param("username") String username);
    public User selone(String username);


}
