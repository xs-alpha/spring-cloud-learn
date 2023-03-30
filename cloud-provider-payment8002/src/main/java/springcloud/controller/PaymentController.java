package springcloud.controller;

import com.atguigu.spring.entities.CommonResult;
import com.atguigu.spring.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author: lpy
 * @Date: 2023/03/06
 */
@RestController
@Slf4j
@EnableEurekaClient
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient; // 服务发现

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        Integer res = paymentService.insert(payment);
        if (res>0){
            return new CommonResult<Payment>(200, "插入数据成功");
        }else{
            return new CommonResult<>(400, "插入数据失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        Payment pay = paymentService.getPaymentById(id);
        return new CommonResult<Payment>(200, "success", pay);
    }
}
