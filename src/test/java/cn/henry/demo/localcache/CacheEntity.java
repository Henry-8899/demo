package cn.henry.demo.localcache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CacheEntity implements Serializable {

    private static final long serialVersionUID = 7172649826282703560L;

    /**
     * 值
     */
    private Object value;

    /**
     * 保存的时间戳（纳秒级别）
     */
    private long gmtModify;

    /**
     * 过期时间（秒级别）
     */
    private int expire;
}
