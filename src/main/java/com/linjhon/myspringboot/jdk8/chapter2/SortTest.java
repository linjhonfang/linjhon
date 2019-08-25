package com.linjhon.myspringboot.jdk8.chapter2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setName("name1");
        apple1.setWeight(150);

        Apple apple2 = new Apple();
        apple2.setName("name2");
        apple2.setWeight(149);

        Apple apple3 = new Apple();
        apple3.setName("name3");
        apple3.setWeight(151);

        List<Apple> list = new ArrayList();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);

//      list.sort(Comparator.comparing(Apple::getWeight));
//        list.sort(Comparator.comparing((Apple a)->a.getWeight()));
//        System.out.println(JSON.toJSON(list));

        List<String> collect = list.stream()
                .filter(a -> a.getWeight() > 149)
                .sorted(Comparator.comparing(Apple::getName))
                .map(Apple::getName)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }
}
