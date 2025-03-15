package top.zhijie.requsetservice.controller;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    private static final String SERVICE_URL = "http://localhost:8086";

    @GetMapping("/httpClientTest")
    public String httpClientTest() throws IOException {
        // 创建 HTTP 客户端
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建 GET 请求
            HttpGet httpGet = new HttpGet(SERVICE_URL + "/hello");

            // 发送请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                if (response.getStatusLine().getStatusCode() == 200) {
                    String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println(result);
                    return "请求成功: " + result;
                }
            }
        }
        return "请求失败";
    }
}