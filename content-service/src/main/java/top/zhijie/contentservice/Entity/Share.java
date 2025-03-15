package top.zhijie.contentservice.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_share")
public class Share {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String title;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean isOriginal;
    private String author;
    private String cover;
    private String summary;
    private Integer price;
    private String downloadUrl;
    private Integer buyCount;
    private Boolean showFlag;
    private String auditStatus;
    private String reason;
}
