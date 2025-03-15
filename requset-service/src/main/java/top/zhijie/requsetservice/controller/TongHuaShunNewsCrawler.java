package top.zhijie.requsetservice.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

public class TongHuaShunNewsCrawler {
    private static final String TARGET_URL = "https://news.10jqka.com.cn/today_list/";

    public static void main(String[] args) {
        // 创建 HttpClient 实例（带连接池配置）
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                .build()) {
            // 发送 GET 请求
            HttpGet httpGet = new HttpGet(TARGET_URL);
            httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.9");

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String html = EntityUtils.toString(entity, "UTF-8");
                    HtmlCleaner cleaner = new HtmlCleaner();
                    TagNode rootNode = cleaner.clean(html);

                    // 使用 XPath 获取新闻标题（需根据页面结构调整）
                    Object[] titleNodes = rootNode.evaluateXPath("//div[@class=\"list-con\"]/ul/li/span[@class=\"arc-title\"]/a\n");

                    System.out.println("----- 最新同花顺新闻列表 -----");
                    for (Object node : titleNodes) {
                        if (node instanceof TagNode) {
                            System.out.println(((TagNode) node).getText());
                        }
                    }
                }
            }
        } catch (XPatherException e) {
            System.err.println("XPath解析失败，请检查表达式：" + e.getMessage());
        } catch (Exception e) {
            System.err.println("请求异常：" + e.getMessage());
        }
    }
}
