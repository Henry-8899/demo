package cn.henry.demo.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayList {

    @Test
    public void test() {

        //和hashmap 不一样，此时就初始化了容器这里
        ArrayList<Object> objects = new ArrayList<>(1);

        //add() 内部有对容量校验
        objects.add(1);
        objects.add(2);
        objects.add(20);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //前闭后开 [0,2) 这样一个区间
        List<Integer> integers1 = integers.subList(0, 2);
        List<Integer> integers2 = integers.subList(2, 4);



        int i = 8 /3;
        System.out.println("end");




    }
}
