package com.crystal.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class springTask {
    @Scheduled(cron = "0/5 * *  * * ?")
    public void sayHello() {
        System.out.println("hello world!");
    }
}