package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConsulConfig {

    @Bean
    @LoadBalanced
    public RestTemplate get(){
        return  new RestTemplate();
    }
}
