package top.zhijie.userservice.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhijie.userservice.Entity.User;
import top.zhijie.userservice.Mapper.UserMapper;
import top.zhijie.userservice.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
