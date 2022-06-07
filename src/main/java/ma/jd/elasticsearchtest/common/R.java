package ma.jd.elasticsearchtest.common;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Slf4j
@Accessors(chain = true)
public class R<T> implements Serializable {
    private boolean success = Boolean.TRUE;//判断接口数据是否正确
    private Boolean login = false;//判断是否登陆
    private String token;//后期针对移动端
    private Integer code = 0;//错误码
    private Integer icon = -1;//-1默认 0叹号 1成功 2失败 3疑问 4锁定 5难过 6微笑
    private Integer count = 0;//返回值如果是数组
    private String msg = "";//错误信息，如果success = false 弹出msg
    private LocalDateTime timestamp = LocalDateTime.now();

    private String jwt;//后台

    private T data;

    public R() {
    }

    public R(T data) {
        if (data == null) {
            this.success = false;
            this.msg = "返回对象为空";
        } else {
            this.data = data;
            if (data instanceof List<?>) {
                if (((List) data).size() > 0) {
                    this.count = ((List) data).size();
                } else {
                    this.msg = "返回数据为空";
                }
            } else if (data instanceof Set<?>) {
                if (((Set) data).size() > 0) {
                    this.count = ((Set) data).size();
                } else {
                    this.msg = "返回数据为空";
                }
            } else if (data instanceof Map<?, ?>) {
                if (((Map) data).size() > 0) {
                    this.count = ((Map) data).size();
                } else {
                    this.msg = "返回数据为空";
                }
            } else {
                this.count = 1;
            }
        }
    }

    public static R ok(Object data, String message) {
        return new R<>(data).setMsg(message);
    }

    public static R error(Object data, String message) {
        return new R<>(data).setMsg(message);
    }

    public R ok() {
        return this;
    }

    public R ok(String message) {
        this.success = true;
        this.msg = message != null ? message : "数据为空";
        return this;
    }

    public R error(String message) {
        this.success = false;
        this.msg = message != null ? message : "数据为空";
        this.code = 500;
        return this;
    }
}