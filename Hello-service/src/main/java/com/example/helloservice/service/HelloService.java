package com.example.helloservice.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getName(){
        return "hello service";
    }

    public String sayHello(String name){
        return "hello " + name;
    }
}
