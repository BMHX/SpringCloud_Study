package top.zhijie.contentservice.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhijie.contentservice.Entity.Share;

@Mapper
public interface ShareMapper {
    @Select("select * from t_share where id = 1")
    Share selectById(Long id);
}
