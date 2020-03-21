package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-19
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced // #LoadBalanced注解开启RestTemplate负载均衡功能  注释掉,手写一个轮训负载均衡算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
