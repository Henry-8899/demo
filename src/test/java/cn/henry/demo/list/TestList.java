package cn.henry.demo.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestList {

    @Test
    public void test() {
        //测试ArrayList删除目标索引位置，之后该位置是为null,还是后面补上
        List<String> integers = Arrays.asList("a","b","c","d","e");
        ArrayList<String> strings = new ArrayList<>(integers);
        strings.remove(2);
        String integer = strings.get(2);  //d
        System.out.println(integer);

        //测试LinkedList删除目标索引位置，之后该位置是为null,还是后面补上
        LinkedList<String> linkedList = new LinkedList<>(integers);
        linkedList.remove(2);
        String s = linkedList.get(2); //d
        System.out.println(s);


    }
}
