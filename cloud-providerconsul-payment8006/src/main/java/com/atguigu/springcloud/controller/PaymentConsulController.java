package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-20
 *
 * @author yanlp
 * @version 1.0
 */
@RestController
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul："+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
