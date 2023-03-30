package com.atguigu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lpy
 * @Date: 2023/03/23
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientMain3355.class, args);
    }
}
