package com.atguigu.spring.controller;

import com.atguigu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: lpy
 * @Date: 2023/03/16
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfoOk(id);
        log.info("*******result: "+ s);
        return s;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfoTimeOut(id);
        log.info("*******result: "+ s);
        return s;
    }


    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("*******result: "+ s);
        return s;
    }

}
