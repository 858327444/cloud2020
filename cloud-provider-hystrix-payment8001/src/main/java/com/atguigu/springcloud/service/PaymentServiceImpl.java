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

    /**
     * @HystrixCommand 报异常后如何处理:
     * 一但调用服务方法失败并抛出了错误信息后
     * 会自动调用@HystrixCommand标注好的fallbackMethod 调用类中的指定方法
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000"),
    })
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e) {e.printStackTrace();}
        // 程序就算写出bug,也会调用fallbackMethod 中的方法
//        int age = 10 / 0;

        return  "线程名字: "+ Thread.currentThread().getName() + " id: "+ id + " paymentInfoTimeout ,耗时(秒):" + timeNumber;
    }

    // paymentInfoTimeoutHandler这个方法必须要与paymentInfoTimeout的参数保持一致,否则报错
    private String paymentInfoTimeoutHandler(Integer id) {
        return "线程名字: "+ Thread.currentThread().getName() + " id: "+ id + " paymentInfoTimeoutHandler ,o(╥﹏╥)o";
    }


}
