package top.zhijie.contentservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.zhijie.contentservice.Service.ShareService;
import top.zhijie.contentservice.model.ShareVO;


@RestController
@RequestMapping("/share")
@RequiredArgsConstructor
public class ShareController {
    private final ShareService shareService;

    @GetMapping("/{id}")
    public ShareVO getShareWithUser(@PathVariable Integer id) throws InterruptedException {
//        Thread.sleep(600);
        return shareService.getShareWithUser(id);
    }
}
