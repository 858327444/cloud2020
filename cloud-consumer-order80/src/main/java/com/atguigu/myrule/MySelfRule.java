package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 添加Ribbon负载均衡规则类
 * 注意:官方文档明确给出了警告,这个自定义配置类不能放在@ComponentScan所扫描的当前包及其子包下,
 * 因为主启动类OrderMain80已经有了@SpringBootApplication注解,点进去该注解发现有@ComponentScan注解
 * 所以要新起个包,写该规则类
 *
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-21
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }


}
