package com.zerah.testboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling       //开启定时任务支持，
public class TestbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestbootApplication.class, args);
    }

}
