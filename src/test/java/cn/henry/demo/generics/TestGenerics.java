package cn.henry.demo.generics;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 泛型测试
 */
public class TestGenerics {

    /**
     * 以下两个方法测试的是关于伪泛型的问题
     * 泛型只存在编译时，不存在于运行时；
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //list.add("a"); // 这样直接添加肯定是不允许的

        //下面通过java的反射，绕过泛型  来给添加字符串
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list,"a");

        System.out.println(list); //[1, a] 输出没有没问题
        System.out.println(list.get(1)); //a
    }


    @Test
    public void Test() throws Exception {
        Map<String, String> map = new HashMap<>();
        String key = "key";
        Integer val = new Integer(1); //备注：此方法在Java9后标注为过期了，建议使用valueOf，使用缓存来提高效率
        Method m = HashMap.class.getDeclaredMethod("put", new Class[]{Object.class, Object.class});
        m.invoke(map, key, val);

        System.out.println(map); //{key=1}
        //但是下面的输出会报错
        System.out.println(map.get(key)); // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    }

}
