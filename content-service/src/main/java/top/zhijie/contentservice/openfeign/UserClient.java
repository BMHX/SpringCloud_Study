package top.zhijie.contentservice.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zhijie.contentservice.Entity.User;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Integer id);
}
