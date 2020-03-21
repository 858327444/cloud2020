package com.atguigu.springcloud.lb;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-21
 *
 * @author yanlp
 * @version 1.0
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;

        do {
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("*******第几次访问: " + next);
        return next;
    }


    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList) {
        if (CollectionUtils.isEmpty(serviceInstanceList)) {
            return null;
        }
        // rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标,每次服务重启后rest接口计数从1开始
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
