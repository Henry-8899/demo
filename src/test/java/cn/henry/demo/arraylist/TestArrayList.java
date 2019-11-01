package cn.henry.demo.arraylist;

import org.junit.Test;

import java.util.ArrayList;

public class TestArrayList {

    @Test
    public void test() {

        //和hashmap 不一样，此时就初始化了容器这里
        ArrayList<Object> objects = new ArrayList<>(1);

        //add() 内部有对容量校验
        objects.add(1);
        objects.add(2);
        objects.add(20);
    }
}
