package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-21
 *
 * @author yanlp
 * @version 1.0
 */
//指定调用哪个服务,payment8001和payment8002的sprig.application.name大写后为这个值
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")//指定调用哪个地址,必须对应上
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
