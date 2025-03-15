package top.zhijie.userservice.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String mobile;
    private String password;
    private String user_name;
    private String avatar_url;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
