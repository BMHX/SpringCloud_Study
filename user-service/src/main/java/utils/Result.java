package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code = 200;
    private String msg = "请求成功";
    private Map<String,String> data;
}
