package cn.henry.demo.collectors;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestGroupBy {

    @Test
    public void test(){
        List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 5),
                new Fruit("apple", 6),
                new Fruit("banana", 2), new Fruit("banana", 7),
                new Fruit("banana", 7), new Fruit("grape",8));

        // group by price, uses 'mapping' to convert List<Fruit> to List<String>
        //{banana=[7, 7, 7], apple=[6, 6], grape=[8]}
        Map<String, List<Integer>> groupMap =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.mapping(Fruit::getPrice, Collectors.toList())));

        //{banana=[7, 7, 7], apple=[6, 6], grape=[8]}
        Multimap<String, Integer> multiMap = ArrayListMultimap.create();
        fruitList.forEach(fruit -> multiMap.put(fruit.getName(), fruit.getPrice()));

        System.out.println("groupMap = " + groupMap);
        System.out.println("multiMap = " + multiMap);

        //g = {banana=3, apple=2, grape=1}
        Map<String, Long> g =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.counting()));
        System.out.println("g = " + g);

        //f = {banana=5.333333333333333, apple=5.5, grape=8.0}
        //返回平均数
        Map<String, Double> f =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.averagingInt(Fruit::getPrice)));

        System.out.println("f = " + f);

        //a = {banana=IntSummaryStatistics{count=3, sum=16, min=2, average=5.333333, max=7}, apple=IntSummaryStatistics{count=2, sum=11, min=5, average=5.500000, max=6}, grape=IntSummaryStatistics{count=1, sum=8, min=8, average=8.000000, max=8}}
        //返回总数、总和、最小值、平均数、最大值
        Map<String, IntSummaryStatistics> a =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.summarizingInt(Fruit::getPrice)));
        System.out.println("a = " + a);


        //只针对字符串收集
        //b = apple;apple;banana;banana;banana;grape
        String b = fruitList.stream().map(Fruit::getName).collect(Collectors.joining(";"));
        System.out.println("b = " + b);

        //h = [apple;apple;banana;banana;banana;grape]
        String h = fruitList.stream().map(Fruit::getName).collect(Collectors.joining(";","[","]"));
        System.out.println("h = " + h);


        //c = Fruit(name=grape, price=8)
        Fruit c = fruitList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Fruit::getPrice))).orElse(null);
        System.out.println("c = " + c);

        //d = Fruit(name=banana, price=2)
        Fruit d = fruitList.stream().collect(Collectors.minBy(Comparator.comparingInt(Fruit::getPrice))).orElse(null);
        System.out.println("d = " + d);

        //e = {banana=Optional[Fruit(name=banana, price=7)], apple=Optional[Fruit(name=apple, price=6)], grape=Optional[Fruit(name=grape, price=8)]}
        Map<String, Optional<Fruit>> e = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.maxBy(Comparator.comparingInt(Fruit::getPrice))));
        System.out.println("e = " + e);

    }
}
