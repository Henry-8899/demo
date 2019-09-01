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
        int i = integer.getAndIncrement();

        System.out.println(i);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 8, 10);
        List<Integer> collect = integers.stream().filter(e -> e > 4).collect(Collectors.toList());
        System.out.println(collect);


    }

}
