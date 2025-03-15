package top.zhijie.requsetservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class ConsumerController2 {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_URL = "http://localhost:8086";

    @GetMapping("/restTemplateTest")
    public String restTemplateTest() {
        return restTemplate.getForObject(SERVICE_URL + "/hello", String.class);
    }
}
