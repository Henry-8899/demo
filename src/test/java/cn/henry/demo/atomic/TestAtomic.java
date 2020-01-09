package cn.henry.demo.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;

public class TestAtomic {

    @Test
    public void test() {

        System.out.println("---------------------AtomicInteger start-----------------------");
        AtomicInteger integer = new AtomicInteger(2);

        int getAndIncrement = integer.getAndIncrement();
        System.out.println("getAndIncrement : " + getAndIncrement + "; integer : " + integer);
        int incrementAndGet = integer.incrementAndGet();
        System.out.println("incrementAndGet : " + incrementAndGet + "; integer : " + integer);

        int andSet = integer.getAndSet(10);
        System.out.println("andSet : " + andSet + "; integer : " + integer);

        int andAdd = integer.getAndAdd(5);
        System.out.println("andAdd : " + andAdd + "; integer : " + integer);

        boolean b = integer.compareAndSet(5, 1);
        System.out.println("b : " + b + "; integer : " + integer);
        System.out.println("---------------------AtomicInteger end-----------------------");


        System.out.println("---------------------AtomicIntegerArray start-----------------------");
        int[] arr = {9, 5, 7, 2};
        AtomicIntegerArray integerArray = new AtomicIntegerArray(arr);

        //获取 index=i 位置元素的值，并让该位置的元素自增
        int andIncrement = integerArray.getAndIncrement(2);
        System.out.println("AtomicIntegerArray_getAndIncrement : " + andIncrement + "; integerArray : " + integerArray);
        int andGet = integerArray.incrementAndGet(2);
        System.out.println("AtomicIntegerArray_incrementAndGet : " + andGet + "; incrementAndGet : " + integerArray);
        int arrayAndAdd = integerArray.getAndAdd(2, 5);
        System.out.println("AtomicIntegerArray_getAndAdd : " + arrayAndAdd + "; incrementAndGet : " + integerArray);
        System.out.println("---------------------AtomicIntegerArray end-----------------------");

        System.out.println("---------------------AtomicStampedReference start-----------------------");
        //利用此stamp初始化值，可有效解决AtomicInteger ABA问题；具体多线程实例：见：https://blog.csdn.net/Alice_8899/article/details/103912228
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(10, 0);
        boolean b1 = stampedReference.compareAndSet(stampedReference.getReference(), 15, stampedReference.getStamp(), stampedReference.getStamp() + 1);

        Integer reference = stampedReference.getReference();
        int stamp = stampedReference.getStamp();
        System.out.println("stamp=" + stamp + "; reference=" + reference);
        System.out.println("---------------------AtomicStampedReference end-----------------------");

    }

}
