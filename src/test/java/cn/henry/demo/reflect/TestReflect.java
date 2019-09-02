package cn.henry.demo.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
/**
 * @Description:映射类相关
 * @Author:hang
 * @Date:2019-09-01 20:02
 **/
public class TestReflect {

    @Test
    public void test() throws Exception {
        /**
         * Class类:反射的核心类，可以获取类的属性，方法等内容信息。 (java.lang #Class)
         * Field类:Java.lang.reflect.表示类的属性，可以获取和设置类的中属性值。( (java.lang.reflect))
         * Method类:Java.lang.reflect。表示类的方法，它可以用来获取类中方法的信息或者执行方法
         * Construcor类:Java.lang.reflect。表示类的构造方法。 (java.lang.reflect)
         */
        //todo 待完善
        Class<?> aClass = Class.forName("cn.henry.demo.enumset.IntEnum");
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields){
            String name = f.getName();
            System.out.println(f.get(name));
        }
    }
}
