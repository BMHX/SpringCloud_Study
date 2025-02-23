package top.zhijie.userservice.Controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user")
    public String getUser(@RequestParam String username){
        String AiServiceUrl = "http://localhost:8084/ask";
        String PythonServiceUrl = "http://localhost:5000/call_python_service";
        String AiInfo = restTemplate.getForObject(AiServiceUrl, String.class);
        String PythonInfo = restTemplate.getForObject(PythonServiceUrl, String.class);

        return "user: " + username + "<p>Ai回复: " + AiInfo + PythonInfo;
    }
}
