package top.zhijie.userservice.Controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.zhijie.userservice.Entity.User;
import top.zhijie.userservice.config.zjProperties;
import utils.Result;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class TestController {
    @Resource
    private zjProperties zjProperties;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getUserinfo")
    public User getUsername(){
        String contentServiceUrl = "http://localhost:8088/share/1";
        User userInfo = restTemplate.getForObject(contentServiceUrl, User.class);
        return userInfo;
    }

    @Value("${ai.deepseek.api-key}")
    private String api_key;
    @Value("${spring.datasource.url}")
    private String database_url;
    @Value("${aliyun.accessKeyId}")
    private String oss_key;


    @GetMapping("/test")
    public String test(){
        String AiServiceUrl = "http://localhost:8084/ask";
        String AiInfo = restTemplate.getForObject(AiServiceUrl, String.class);

        return "API_key: " + api_key + "<p>Ai回复: " + AiInfo + "<p>数据库配置"+ database_url + "<p>OSS-KEY：" + oss_key;
    }
}
