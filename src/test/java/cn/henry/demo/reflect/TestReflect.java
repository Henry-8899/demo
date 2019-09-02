package cn.henry.demo.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

        System.out.println("-------------------- Class reflect start ----------------------------------");

        //获得类 by forname
        Class<?> aClass = Class.forName("cn.henry.demo.reflect.SourceRequest");

        SourceRequest request = new SourceRequest(1, 2L);

        Class<? extends SourceRequest> requestClass = request.getClass();
        //获得该类下 所有字段
        Field[] fields = requestClass.getDeclaredFields();


        //获得注解
        Annotation[] declaredAnnotations = requestClass.getDeclaredAnnotations();

        //获得所有构造器
        Constructor<?>[] constructors = requestClass.getConstructors();

        //获得类下方法  java.lang.Integer cn.henry.demo.reflect.SourceRequest.getMax()
        Method[] declaredMethods = requestClass.getDeclaredMethods();

        //获得指定方法
        Method declaredMethod = requestClass.getDeclaredMethod("getMax");

        //判断类是否是 注解类 数组 枚举 接口;类上是否存在该注解;
        boolean annotation = Log.class.isAnnotation();
        boolean array = requestClass.isArray();
        boolean anEnum = Log.class.isEnum();
        boolean anInterface = requestClass.isInterface();
        boolean annotationPresent = requestClass.isAnnotationPresent(Log.class);

        //获得新实例 空参对象
        Object newInstance = aClass.newInstance();
        if (newInstance instanceof SourceRequest) {
            SourceRequest cast = SourceRequest.class.cast(newInstance);
            cast.setSourceId(888L);
            System.out.println(cast.getSourceId());
        }


        System.out.println("-------------------- Class reflect end ----------------------------------");


        System.out.println("-------------------- Field reflect start ----------------------------------");
        for (Field f : fields) {
            //使可以用反射时访问私有变量
            f.setAccessible(true);
            //获得字段name
            String name = f.getName();
            //f.get(obj) obj:从中提取表示字段的值的对象
            Object o = f.get(request);
            System.out.println(o);
        }

        System.out.println("-------------------- Field reflect end ----------------------------------");

    }
}
