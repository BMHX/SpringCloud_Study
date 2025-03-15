package top.zhijie.aiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhijie.aiservice.Service.DeepSeekService;

@RestController
@RequestMapping("/api/deepseek")
public class DeepSeekController {

    @Autowired
    private DeepSeekService deepSeekService;

//    // 直接通过 URL 参数传递问题
//    @GetMapping("/ask")
//    public String askQuestion(@RequestParam String question) {
//        return deepSeekService.askQuestion(question);
//    }

    // 或通过 POST Body 传递问题（原始字符串）
    @PostMapping("/ask")
        public String askQuestion(@RequestBody String question) {
        return deepSeekService.askQuestion(question);
    }
}