package top.zhijie.requsetservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConsumerController4 {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_URL = "https://www.wanandroid.com";

    @GetMapping("/restTemplateTest1")
    public String restTemplateTest() {
        return restTemplate.getForObject(SERVICE_URL + "/article/list/0/json", String.class);
    }
}
