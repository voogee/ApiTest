package com.voogee.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.voogee.bean.Message;
import com.voogee.bean.User;
import com.voogee.mapper.MessageMapper;
import com.voogee.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageMapper messageMapper;

    @Override
    public Message addmessage(String msgString) {
        String msgStringcode = msgString.replace("{", "\\{").replace("}", "\\}");
        System.out.println(msgStringcode);
        JSONObject msg = JSON.parseObject(msgStringcode);
        System.out.println(msg);
        String username  =msg.getString("username");
        String topic = msg.getString("topic");
        int qos = msg.getInteger("qos");
        String clientid = msg.getString("clientid");
        String publish_received_at = msg.getString("publish_received_at");
        String payload = msg.getString("payload");
        String event = msg.getString("event");
        System.out.println(username);
        Message m = new Message();
        m.setUsername(username);
        m.setTopicname(topic);
        m.setQos(qos);
        m.setClientid(clientid);
        m.setPublish_received_at(publish_received_at);
        m.setPayload(payload);
        m.setEvent(event);
        messageMapper.addMessage(m);
        return null;
    }

    @Override
    public List<User> getmessage(HttpServletRequest request) {
        return null;
    }
}
