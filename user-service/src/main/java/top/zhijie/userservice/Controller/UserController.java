package top.zhijie.userservice.Controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.zhijie.userservice.Entity.User;
import top.zhijie.userservice.Mapper.UserMapper;
import top.zhijie.userservice.Service.UserService;

@RequestMapping("/user")
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
    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

}
