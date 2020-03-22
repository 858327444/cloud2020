package com.atguigu.springcloud.service;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-22
 *
 * @author yanlp
 * @version 1.0
 */
public interface PaymentService {

    String paymentInfoOK(Integer id);

    String paymentInfoTimeout(Integer id);
}
