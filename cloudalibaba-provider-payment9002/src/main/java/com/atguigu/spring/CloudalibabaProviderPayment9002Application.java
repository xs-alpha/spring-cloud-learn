package com.atguigu.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaosheng
 * @EnableDiscoveryClient 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
 * @date 2020/12/18 16:05
 * @description 支付服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaProviderPayment9002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9002Application.class, args);
        System.out.println("启动成功");
    }

}
