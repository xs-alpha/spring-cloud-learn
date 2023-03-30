package springcloud.service;


import com.atguigu.spring.entities.Payment;

/**
 * @author: lpy
 * @Date: 2023/03/06
 */
public interface PaymentService {
    Integer insert(Payment payment);

    Payment getPaymentById(Long id);

}
