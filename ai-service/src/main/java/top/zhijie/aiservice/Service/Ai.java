package top.zhijie.aiservice.Service;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import top.zhijie.aiservice.pojo.Message;
import top.zhijie.aiservice.pojo.RequestBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Ai {
    public static String GetReply(String qusetion) {
        try {
            // 创建请求体
            RequestBody requestBody = new RequestBody(
                    "qwen2.5-14b-instruct-1m",
                    new Message[]{
                            new Message("system", "You are a helpful assistant."),
                            new Message("user", qusetion)
                    }
            );

            // 将请求体转换为 JSON
            Gson gson = new Gson();
            String jsonInputString = gson.toJson(requestBody);

            // 创建 URL 对象
            URL url = new URL("https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // 设置请求方法为 POST
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Accept", "application/json");

            // 若没有配置环境变量，请用百炼API Key将下行替换为：String apiKey = "sk-xxx";
            String apiKey = System.getenv("sk-ac606c0a7a9e4482bbf034b82c517970");
            String auth = "Bearer " + apiKey;
            httpURLConnection.setRequestProperty("Authorization", auth);

            // 启用输入输出流
            httpURLConnection.setDoOutput(true);

            // 写入请求体
            try (OutputStream os = httpURLConnection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 获取响应码
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 读取响应体
            try (BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response Body: " + response);
                return response.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
        return null;
    }
}
