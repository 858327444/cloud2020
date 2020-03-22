package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-22
 *
 * @author yanlp
 * @version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "线程名字: "+ Thread.currentThread().getName() + " paymentInfoOK  id:" + id;
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e) {e.printStackTrace();}

        return  "线程名字: "+ Thread.currentThread().getName() + " id: "+ id + " paymentInfoTimeout ,耗时(秒):" + timeNumber;
    }
}
