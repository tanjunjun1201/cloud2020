package com.atuigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atuigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private   String serverport;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****输出结果是"+result);
        if(result > 0){
            return  new CommonResult(200,"成功+端口号为"+serverport,result);
        }else {
            return  new CommonResult(444,"失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********插入的结果是"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,端口号为"+serverport,payment);
        }else{
            return new CommonResult(400,"查询失败"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public  String getServerport(){
        return serverport;
    }

    @GetMapping("/hello")
    public String hello(){
        return  "success";
    }



    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        return this.discoveryClient;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi zipkin payment";
    }
}