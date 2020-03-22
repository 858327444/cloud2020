package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-22
 *
 * @author yanlp
 * @version 1.0
 */
@Component
public class PaymentFallbackHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "PaymentFallbackHystrixServiceImpl fallback paymentInfoOK  o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackHystrixServiceImpl fallback paymentInfoTimeout  o(╥﹏╥)o";
    }
}
