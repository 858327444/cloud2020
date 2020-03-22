package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-22
 *
 * @author yanlp
 * @version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix80.class,args);
    }
}
