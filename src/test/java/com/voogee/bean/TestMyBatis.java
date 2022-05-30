package com.voogee.bean;


import com.voogee.APP;
import com.voogee.mapper.MessageMapper;
import com.voogee.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)

public class TestMyBatis {

//    @Resource
//    UserMapper userMapper;
//    @Test
//    public void testLogin(){
//        System.out.println(userMapper);
//        User u = new User();
//        u.setUsername("八戒");
//        u.setPassword("admin123");
//        User loginuser = userMapper.login(u);
//        System.out.println(loginuser);
//    }

    @Resource
    MessageMapper messageMapper;
    @Test
    public void test(){
        System.out.println(messageMapper);
        Message m = new Message();
        m.setTopicname("testtopic2");
        m.setQos(0);
        m.setClientid("asdsa");
        m.setPublish_received_at("12323123214312342");
        m.setPayload("fas");
        m.setEvent("afa");
        messageMapper.addMessage(m);
        List<Message> list = messageMapper.getMessage(m);
        for(Message m1:list){
            System.out.println(m1);
        }



    }




}
