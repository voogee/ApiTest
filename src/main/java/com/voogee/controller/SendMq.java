package com.voogee.controller;


//import com.voogee.mqtt.MyMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Component
@Controller
@Scope("prototype")
@RequestMapping("mq")
public class SendMq implements MqttCallback, IMqttMessageListener {

    @Autowired
//    private MyMqttClient client;

    @Override
    public void connectionLost(Throwable throwable) {

    }


    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
//        client.publishMessage("testtopic2","2",2);
    }

//    @ResponseBody
//    @RequestMapping("sedmq")
//    public GenController messageArrived(HttpServletRequest request) throws Exception {
//        String topicname = request.getParameter("topicname");
//        String message = request.getParameter("message");
//        int qos = Integer.parseInt(request.getParameter("qos"));
//        client.publishMessage(topicname,message,qos);
//        GenController result = new GenController();
//        return result;
//
//    }


    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
