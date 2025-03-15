package top.zhijie.aiservice.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@Service
public class DeepSeekService {

    @Value("${ai.deepseek.api-url}")
    private String apiUrl;

    @Value("${ai.deepseek.api-key}")
    private String apiKey;

    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DeepSeekService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String askQuestion(String question) {
        try {
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "deepseek-chat");
            requestBody.put("messages", List.of(
                    Map.of("role", "user", "content", question)
            ));
            requestBody.put("temperature", 0.7);
            requestBody.put("stream", false); // 明确关闭流式输出

            String responseJson = webClient.post()
                    .uri(apiUrl)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // 解析 JSON 并提取回复内容
            JsonNode rootNode = objectMapper.readTree(responseJson);
            return rootNode.path("choices").get(0)
                    .path("message").path("content").asText();
        } catch (Exception e) {
            return "请求失败: " + e.getMessage();
        }
    }
}