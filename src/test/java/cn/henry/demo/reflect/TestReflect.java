package cn.henry.demo.reflect;

import cn.henry.demo.instance.TestInstance;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Date;

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

        SourceRequest request = new SourceRequest(1, 2);

        Class<? extends SourceRequest> requestClass = request.getClass();
        //获得该类下 所有字段
        Field[] fields = requestClass.getDeclaredFields();
        //获得 指定公共字段
        Field sourceType = requestClass.getField("sourceType");


        //获得注解
        Annotation[] declaredAnnotations = requestClass.getDeclaredAnnotations();
        //获得指定注解
        Log classAnnotation = requestClass.getAnnotation(Log.class);

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
            cast.setSourceId(888);
            System.out.println(cast.getSourceId());
        }

        /**
         * 判断某对象是否是某个类的实例
         * @see TestInstance
         */


        System.out.println("-------------------- Class reflect end ----------------------------------");


        System.out.println("-------------------- Field reflect start ----------------------------------");
        for (Field f : fields) {
            //使可以用反射时访问私有变量
            f.setAccessible(true);
            //获得字段name
            String name = f.getName();
            //f.get(obj) obj:从中提取表示字段的值的对象
            Object o = f.get(request);

            //f.set(obj,value) obj:从中提取表示字段的值的对象 value:目标值
            f.set(request, 3);
            System.out.println(o);
        }
        System.out.println("-------------------- Field reflect end ----------------------------------");

        System.out.println("-------------------- Method reflect start ----------------------------------");

        //获得指定带有参数的方法
        Method getMinMethod = aClass.getDeclaredMethod("getMin", int.class, String[].class);

        //获得方法的修饰符 public
        int modifiers = getMinMethod.getModifiers();
        String string = Modifier.toString(modifiers);

        //获得方法上注解；是否存在
        Log methodAnnotation = getMinMethod.getAnnotation(Log.class);
        boolean annotationPresent1 = getMinMethod.isAnnotationPresent(Log.class);

        //获得方法参数个数
        int parameterCount = getMinMethod.getParameterCount();

        Method getDate = aClass.getDeclaredMethod("getDate", Date.class);

        //获得方法参数类型
        //两者区别 见：https://stackoverflow.com/questions/6747383/difference-between-getgenericparametertypes-and-getparametertypes
        Class<?>[] parameterTypes = getDate.getParameterTypes();
        Type[] genericParameterTypes = getDate.getGenericParameterTypes();

        //动态执行方法
        Object invoke = getMinMethod.invoke(newInstance, 1, new String[]{"a,", "b"});

        Method[] classDeclaredMethods = aClass.getDeclaredMethods();
        for (Method m : classDeclaredMethods){
            //获得 method name
            String name = m.getName();
            //获得方法返回类型
            Class<?> returnType = m.getReturnType();
            Type genericReturnType = m.getGenericReturnType();

            System.out.println(String.format(" method name : %s; returnType: %s",name,returnType.toString()));
        }
        System.out.println("-------------------- Method reflect end ----------------------------------");


    }
}
