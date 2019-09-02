package cn.henry.demo.byvalue;

import org.junit.Test;

public class TestByValue {

    /**
     * 值传递:一般情况下，基本类型，String 为值传递；引用类型 为引用传递；
     * @see: https://blog.csdn.net/Norte_L/article/details/80250057
     */
    @Test
    public void test() {
        int x = 5;
        int y = count (x);
        System.out.println(String.format("x = %d",x));
        System.out.println(String.format("y = %d",y));



    }

    private int count(int x) {
        return (--x);
    }
}
