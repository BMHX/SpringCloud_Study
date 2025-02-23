package top.zhijie.aiservice.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.zhijie.aiservice.Service.Ai;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class AIController {

    @Value("${aliyun.api-key}")
    private String API_KEY ; // 从配置读取API密钥
    private static final String ENDPOINT = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

    @GetMapping("/ask")
    public String askQuestion() throws IOException, InterruptedException {
        String prompt = "你好，请介绍一下你自己";

        String requestBody = String.format("""
    {
        "model": "qwen-turbo",
        "input": {
            "messages": [
                {"role": "user", "content": "%s"}
            ]
        }
    }
    """, prompt);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 解析响应的 JSON 数据
        JSONObject responseJson = new JSONObject(response.body());

        // 提取 text 部分
        return responseJson.getJSONObject("output").getString("text") + "</p>";
    }
}