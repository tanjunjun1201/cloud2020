package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = FeignHystrixFallBack.class)
public interface FeignHystrixService {


    @GetMapping("/payment/hystrix/ok/{id}")
    public String getok(@PathVariable("id")Integer id);


    @GetMapping("/payment/hystrix/fail/{id}")
    public String getfail(@PathVariable("id")Integer id);
}
