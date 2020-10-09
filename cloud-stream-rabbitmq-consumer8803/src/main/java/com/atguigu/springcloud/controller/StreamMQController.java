package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class StreamMQController {

    @Value("${server.port}")
    private  String serverport;

    @StreamListener(Sink.INPUT)
    public void germessage(Message<String> message){
        System.out.println("8003收到消息"+message.getPayload()+"port: "+serverport);
    }
}
