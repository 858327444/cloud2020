package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-19
 *
 * @author yanlp
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain80.class);
    }
}
