package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-22
 *
 * @author yanlp
 * @version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfoGlobalFallbackHandler")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentInfoFallbackHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
//        int a = 10/0;
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info(result);
        return result;
    }

    private String paymentInfoFallbackHandler(Integer id) {
        return "我是80消费者端口,系统繁忙或出现错误" + Thread.currentThread().getName() + " id: " + id + " o(╥﹏╥)o";
    }

    private String paymentInfoGlobalFallbackHandler() {
        return "Global异常处理信息,请稍后再试 o(╥﹏╥)o";
    }

}
