package com.voogee.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private String username;
    private String topicname;
    private int qos;
    private String clientid;
    private String publish_received_at;
    private String payload;
    private String event;

}
