package top.zhijie.requsetservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zhijie.requsetservice.openfeign.HelloService;

@RestController
public class ConsumerController6 {
    @Resource
    private HelloService helloService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        return helloService.hi(name);
    }
}
