package com.linjhon.myspringboot.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.linjhon.myspringboot.schedule")
@EnableScheduling
public class TaskSchedulerConfig {

}
