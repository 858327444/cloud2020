package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="500")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e) {e.printStackTrace();}

        return  "线程名字: "+ Thread.currentThread().getName() + " id: "+ id + " paymentInfoTimeout ,耗时(秒):" + timeNumber;
    }

    private String paymentInfoTimeoutHandler(Integer id) {
        return "线程名字: "+ Thread.currentThread().getName() + " id: "+ id + " paymentInfoTimeoutHandler ,o(╥﹏╥)o";
    }


}
