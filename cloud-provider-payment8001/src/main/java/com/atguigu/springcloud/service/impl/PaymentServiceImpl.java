package com.atguigu.springcloud.service.impl;

import com.atguigu.spring.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author: lpy
 * @Date: 2023/03/06
 */
@Service
public class PaymentServiceImpl implements PaymentService {
//    @Resource
//    private PaymentDao paymentDao;

    @Override
    public Integer insert(Payment payment) {
        return 1;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = new Payment();
        payment.setId(id);
        payment.setSerial("serial:"+id);
        return payment;
    }


}
