package com.linjhon.myspringboot;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class MyspringbootApplicationTest {

    public static void main(String[] args) {
        Set treeSet = new TreeSet();
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("d");
        treeSet.add("c");
        System.out.println(treeSet);
    }

}