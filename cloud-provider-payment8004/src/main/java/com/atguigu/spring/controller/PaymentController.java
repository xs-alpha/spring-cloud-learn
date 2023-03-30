package com.atguigu.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: lpy
 * @Date: 2023/03/10
 */
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port")
    private String port;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud zookeeper:"+port+ UUID.randomUUID().toString();
    }
}
