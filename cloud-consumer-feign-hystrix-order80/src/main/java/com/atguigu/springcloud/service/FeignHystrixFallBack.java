package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrixFallBack implements FeignHystrixService {
    @Override
    public String getok(Integer id) {
        return "对方服务器宕机";
    }

    @Override
    public String getfail(Integer id) {
        return null;
    }
}
