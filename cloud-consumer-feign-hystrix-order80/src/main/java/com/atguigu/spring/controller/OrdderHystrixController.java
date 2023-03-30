package com.atguigu.spring.controller;

import com.atguigu.spring.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: lpy
 * @Date: 2023/03/16
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrdderHystrixController {
    @Resource
    private OrderHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000")
//    })
    // 没有指明使用哪一个,使用全局的
    @HystrixCommand
    public String paymentInfoTimeOutClient(@PathVariable("id") Integer id){
        int timeNumber = 3;
        int i = 9 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" +Thread.currentThread().getName()+"耗时"+timeNumber+"秒 payment_ok_time out id:"+id+" success";
    }

    public String paymentInfoTimeOutHandler(Integer id){
        return "线程池：" +Thread.currentThread().getName()+"系统繁忙，请稍候再试:"+"【表情】";
    }

    // 下面是全局fallback

    public String paymentGlobalFallbackMethod(){
        return "Global 222对方系统繁忙或者宕机，请稍候再试，【表情】";
    }
}
