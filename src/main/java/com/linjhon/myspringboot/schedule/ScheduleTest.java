package com.linjhon.myspringboot.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduleTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

    }
}
