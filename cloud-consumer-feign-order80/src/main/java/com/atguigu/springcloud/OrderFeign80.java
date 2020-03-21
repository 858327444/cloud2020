package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-21
 *
 * @author yanlp
 * @version 1.0
 */
@SpringBootApplication
@EnableFeignClients // 开启Feign
public class OrderFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class, args);
    }
}
