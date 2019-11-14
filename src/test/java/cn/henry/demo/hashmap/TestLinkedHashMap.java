package cn.henry.demo.hashmap;

import org.junit.Test;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {


    @Test
    public void test() {

        /**
         * 探究执行过程
         */
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>(6);

        linkedHashMap.put("1","a");
    }
}
