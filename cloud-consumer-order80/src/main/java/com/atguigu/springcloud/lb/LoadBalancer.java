package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 模拟 ILoadBalancer 的接口，选择哪一个负载算法和机器
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-21
 *
 * @author yanlp
 * @version 1.0
 */
public interface LoadBalancer {
    /**
     * 从Eureka获取的实例服务集合中,通过手写的负载均衡算法选出一个服务
     *
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList);

}
