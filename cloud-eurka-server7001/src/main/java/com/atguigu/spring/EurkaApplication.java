package com.atguigu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: lpy
 * @Date: 2023/03/07
 */
@SpringBootApplication
@EnableEurekaServer
public class EurkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurkaApplication.class, args);
    }
}
