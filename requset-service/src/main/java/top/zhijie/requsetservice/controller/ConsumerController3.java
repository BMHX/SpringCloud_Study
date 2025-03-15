package top.zhijie.requsetservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ConsumerController3 {
    private final String SERVICE_URL = "http://Localhost:8086";
    private final WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    @GetMapping("/webClientTest")
    public String webClientTest() {
        Mono<String> mono = webClient.get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class);

        mono.subscribe(System.out::println);
        return "请求成功";
    }
}
