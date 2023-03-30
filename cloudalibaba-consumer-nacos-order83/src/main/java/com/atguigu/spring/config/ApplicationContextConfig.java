package com.atguigu.spring.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced     // RestTemplate 结合ribbon做负载均衡的时候一定要加，不然会报错nested exception is java.net.UnknownHostException: nacos-payment-provider
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
