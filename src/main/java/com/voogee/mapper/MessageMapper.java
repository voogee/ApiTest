package com.voogee.mapper;


import com.voogee.bean.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper{

    public List<Message> getMessage(Message message);
    public int addMessage(Message message);
}
