package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.FeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "gloablhandler")
public class FeignHystrixController {


    @Resource
    private FeignHystrixService feignHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String getok(@PathVariable("id")Integer id){
        return feignHystrixService.getok(id);
    }


//    @HystrixCommand(fallbackMethod = "getfailhandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/fail/{id}")
    public String getfail(@PathVariable("id")Integer id){
        int i =10/0;
        return  feignHystrixService.getfail(id);
    }

    public  String getfailhandler(@PathVariable("id")Integer id){
        return "80系统报错";
    }

    public String gloablhandler(){
        return "全部配置错误！！！";
    }
}
