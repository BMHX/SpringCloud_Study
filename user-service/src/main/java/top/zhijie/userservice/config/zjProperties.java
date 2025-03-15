package top.zhijie.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "zjq")
public class zjProperties {
    private String username;
    private String job;
    private String serviceFlag;
}
