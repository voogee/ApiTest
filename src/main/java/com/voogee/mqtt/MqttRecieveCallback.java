//package com.voogee.mqtt;
//
//import org.eclipse.paho.client.mqttv3.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//@Component
//public class MqttRecieveCallback implements MqttCallback, IMqttMessageListener {
//
//
//
//    @Autowired
//    private MyMqttClient client;
//
//    @Override
//    public void connectionLost(Throwable cause) {
//
//    }
//
//    @Override
//    public void messageArrived(String topic, MqttMessage message)  {
//        System.out.println("Client 接收消息主题 : " + topic);
//        System.out.println("Client 接收消息Qos : " + message.getQos());
//        System.out.println("Client 接收消息内容 : " + new String(message.getPayload()));
//
//        /**
//         * 发送消息
//         */
//        client.publishMessage("testtopic2","2",2);
//    }
//
//    @Override
//    public void deliveryComplete(IMqttDeliveryToken token) {
//
//    }
//
//}
