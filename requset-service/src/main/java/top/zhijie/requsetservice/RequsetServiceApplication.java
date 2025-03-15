package top.zhijie.requsetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages={"top.zhijie.requsetservice.openfeign"})
public class RequsetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequsetServiceApplication.class, args);
    }

}
