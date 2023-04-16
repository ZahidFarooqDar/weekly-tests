package com.geekster.SpringAnnotations.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public String getMessage() {
        return "Hello, World!";
    }
}
