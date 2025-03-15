package top.zhijie.contentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareVO {
    private Integer id;
    private String title;
    private String author;
    private String cover;
    private String summary;
    private Integer price;
    private UserDTO user;
}
