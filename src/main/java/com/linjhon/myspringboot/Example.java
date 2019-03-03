package com.linjhon.myspringboot;

import java.lang.instrument.Instrumentation;

public class Example {



    public static void premain(String  args, Instrumentation inst){

        System.out.print("java agent example");
        Object obj = new Object();
        long size = inst.getObjectSize(obj);
        System.out.println(size);

    }
}
