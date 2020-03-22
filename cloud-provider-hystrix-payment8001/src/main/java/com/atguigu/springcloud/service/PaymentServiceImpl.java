package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
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
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),//单位:毫秒
    })
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e) {e.printStackTrace();}
        // 程序就算写出bug,也会调用fallbackMethod 中的方法
//        int age = 10 / 0;

        return  "线程名字: "+ Thread.currentThread().getName() + " id: "+ id + " paymentInfoTimeout ,耗时(秒):" + timeNumber;
    }

    // paymentInfoTimeoutHandler这个方法必须要与paymentInfoTimeout的参数保持一致,否则报错
    private String paymentInfoTimeoutHandler(Integer id) {
        return "线程名字: "+ Thread.currentThread().getName() + " 系统繁忙或系统出现错误 id: "+ id + " paymentInfoTimeoutHandler ,o(╥﹏╥)o";
    }



    // 熔断  @HystrixProperty里面的内容是从HystrixCommandProperties类中找到的
    // 下面的意思是  10次请求在10秒内,如果失败率达到60%,即开始熔断,熔断后正确的请求也不会立刻响应,而是缓慢,正确率高的时候才响应
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后开始熔断
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数" );
        }
        String number = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " paymentCircuitBreaker  number : " + number;
    }

    private String paymentCircuitBreakerHandler(Integer id) {
        return "paymentCircuitBreakerHandler o(╥﹏╥)o id :" + id;
    }


}
