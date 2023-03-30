package com.atguigu.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: lpy
 * @Date: 2023/03/10
 */
@RestController
public class PaymentController {
    @Value("${server.port")
    private String port;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud consul:"+port+ UUID.randomUUID().toString();
    }
}
