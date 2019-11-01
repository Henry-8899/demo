package cn.henry.demo.hashmap;

import org.junit.Test;

import java.util.HashMap;

public class TestHashMap {


    @Test
    public void test() {

        /**
         * 这一步 虽然初始化了容量，但是会重新计算合适的容量的大小，之后在put()方法才会实际扩容
         * 可debug 追踪
         */
        HashMap<Object, Object> hashMap = new HashMap<>(9);
        hashMap.put("a","1");
        System.out.println(hashMap.size());

        int i = tableSizeFor(17);
        System.out.println(i);

    }


    static final int MAXIMUM_CAPACITY = 1 << 30;


    /**
     * HashMap 中计算数组容量的源代码
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
