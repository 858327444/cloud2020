package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Program Name: cloud2020
 * Created by yanlp on 2020-03-25
 *
 * @author yanlp
 * @version 1.0
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

}
