package com.yl.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author vaeling.you
 */
public class GroupingBy {

    public static void main(String[] args) {

        List<String> items =
                Arrays.asList("苹果", "苹果", "香蕉",
                        "苹果", "橙", "香蕉", "木瓜");

        //分组List并显示其总数。 result -> {香蕉=2, 苹果=3, 木瓜=1, 橙=1}
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //添加排序. result -> {苹果=3, 香蕉=2, 木瓜=1, 橙=1}
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);


        List<Item> items1 = Arrays.asList(
                new Item("苹果", 10, new BigDecimal("9.99")),
                new Item("香蕉", 20, new BigDecimal("19.99")),
                new Item("木瓜", 10, new BigDecimal("29.99")),
                new Item("西瓜", 10, new BigDecimal("29.99")),
                new Item("木瓜", 20, new BigDecimal("9.99")),
                new Item("苹果", 10, new BigDecimal("9.99")),
                new Item("香蕉", 10, new BigDecimal("19.99")),
                new Item("苹果", 20, new BigDecimal("9.99"))
        );

        //按名称+数字或数量组合. result -> {香蕉=30, 苹果=40, 木瓜=30, 西瓜=10}
        Map<String, Integer> sum = items1.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);

        //按价格分组. result -> {19.99=[Item(name=香蕉, qty=20, price=19.99), Item(name=香蕉, qty=10, price=19.99)], 29.99=[Item(name=木瓜, qty=10, price=29.99), Item(name=西瓜, qty=10, price=29.99)], 9.99=[Item(name=苹果, qty=10, price=9.99), Item(name=木瓜, qty=20, price=9.99), Item(name=苹果, qty=10, price=9.99), Item(name=苹果, qty=20, price=9.99)]}
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items1.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        // 按价格分组,映射到Set. {19.99=[香蕉], 29.99=[木瓜, 西瓜], 9.99=[苹果, 木瓜]}
        Map<BigDecimal, Set<String>> result1 =
                items1.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println(result1);

        // 按价格分组,计算数量.
        Map<BigDecimal, Long> result2 =
                items1.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.counting()
                        )
                );

        System.out.println(result2);

    }
}