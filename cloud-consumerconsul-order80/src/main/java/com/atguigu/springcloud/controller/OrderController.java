package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-19
 *
 * @author yanlp
 * @version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CONSUL-PROVIDER-PAYMENT";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consul () {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul" ,String.class);
    }

}
