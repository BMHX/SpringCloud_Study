package top.zhijie.userservice.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhijie.userservice.Entity.User;
import top.zhijie.userservice.Mapper.UserMapper;

public interface UserService {

    public User getUserById(Integer id);
}
