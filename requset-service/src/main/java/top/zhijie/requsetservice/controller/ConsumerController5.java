package top.zhijie.requsetservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ConsumerController5 {
    private final String SERVICE_URL = "https://www.wanandroid.com";
    private final WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    @GetMapping("/webClientTest1")
    public Mono<String> webClientTest(@RequestParam String page) {
        return webClient.get()
                .uri("/article/list/{page}/json", page) // 使用路径参数更规范
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e ->
                        Mono.just("{\"error\": \"" + e.getMessage() + "\"}"));
    }
}
