package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class Order83Controller {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private  String serverurl;


    @GetMapping("/consumer/payment/nacos/{id}")
    public String getServerurl(@PathVariable("id") Long id){
        return  restTemplate.getForObject(serverurl+"/payment/nacos/"+id,String.class);
    }
}
