package top.zhijie.contentservice.openfeign;

import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.zhijie.contentservice.Entity.User;
import top.zhijie.contentservice.Service.ShareService;
import top.zhijie.contentservice.model.ShareVO;
import top.zhijie.contentservice.utils.Result;
@Component
@Slf4j
public class UserServiceFallBackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        log.error("用户服务调用异常",cause);
        return new UserClient(){
            @Override
            public User getUserById(Integer id) {
                User user = new User();
                user.setId(-1);
                user.setUser_name("用户服务异常");
                return user;
            }
        };
    }
}
