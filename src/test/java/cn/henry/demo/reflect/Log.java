package cn.henry.demo.reflect;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 是否打印出参日志； 默认：打印
     * @return
     */
    boolean isPrintOutParam() default true;
}
