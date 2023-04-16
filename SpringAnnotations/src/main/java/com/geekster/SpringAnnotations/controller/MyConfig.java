package com.geekster.SpringAnnotations.controller;

import com.geekster.SpringAnnotations.service.MyService;
import com.geekster.SpringAnnotations.service.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
