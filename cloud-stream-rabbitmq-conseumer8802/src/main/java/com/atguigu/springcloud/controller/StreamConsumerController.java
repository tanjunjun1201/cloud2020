package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@EnableBinding(Sink.class)
@Component
public class StreamConsumerController {
    @Value("${server.port}")
    private String serverport;


    @StreamListener(Sink.INPUT)
    public void getmessage(Message<String> message){
        System.out.println("8801收到消息： "+message.getPayload()+"\t port: "+serverport);
    }
}
