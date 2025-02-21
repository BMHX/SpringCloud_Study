package top.zhijie.productservice.Controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @GetMapping("/product")
    public String getProduct(@RequestParam String product_name) {
        return "product: " + product_name;

    }
}
