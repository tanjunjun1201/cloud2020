package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Payment9002Controller {
    @Value("${server.port}")
    private  String serverport;

    @GetMapping("/payment/nacos/{id}")
    public String getServerport(@PathVariable("id")Integer id){
        return "nacos registry, server port :"+serverport + "\t id"+id;
    }
}
