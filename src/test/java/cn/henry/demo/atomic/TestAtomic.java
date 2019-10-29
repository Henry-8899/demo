package cn.henry.demo.atomic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestAtomic {

    @Test
    public void test() {
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


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 8, 10);
        List<Integer> collect = integers.stream().filter(e -> e > 4).collect(Collectors.toList());
        System.out.println(collect);


    }

}
