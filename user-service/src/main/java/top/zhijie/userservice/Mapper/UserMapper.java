package top.zhijie.userservice.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhijie.userservice.Entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from t_user where id = 1")
    User selectById(Long id);
}