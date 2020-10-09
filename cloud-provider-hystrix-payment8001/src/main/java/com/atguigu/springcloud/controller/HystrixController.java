package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixController {
    @Resource
    private HystrixService hystrixService;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String getok(@PathVariable("id")Integer id){
        return  hystrixService.getok(id);
    }


    @GetMapping("/payment/hystrix/fail/{id}")
    public String getfail(@PathVariable("id")Integer id){
        return hystrixService.getfail(id);
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = hystrixService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
