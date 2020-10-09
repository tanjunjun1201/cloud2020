package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.SendMessageService;
import com.atguigu.springcloud.service.impl.SendMessageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private SendMessageServiceImpl sendMessageService;

    @GetMapping("/sendMessage")
    public String sendmessage(){
        return  sendMessageService.send();
    }
}
