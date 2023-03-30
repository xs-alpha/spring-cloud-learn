package com.atguigu.spring.service;

import org.springframework.stereotype.Service;

/**
 * @author: lpy
 * @Date: 2023/03/20
 */
@Service
public class OrderHystrixServiceImpl implements OrderHystrixService{
    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "paymentInfoTimeOut: fall back,";
    }

    @Override
    public String paymentInfoOk(Integer id) {
        return "paymentInfoOk fall back";
    }
}
