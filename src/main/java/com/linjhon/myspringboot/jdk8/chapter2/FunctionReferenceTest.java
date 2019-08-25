package com.linjhon.myspringboot.jdk8.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FunctionReferenceTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("B","A","b","a");
//        list.sort((a,b)->a.compareToIgnoreCase(b));
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);

    }
}
