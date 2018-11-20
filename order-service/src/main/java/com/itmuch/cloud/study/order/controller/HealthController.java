package com.itmuch.cloud.study.order.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@Api(tags = "1.2", description = "健康服务", value = "健康服务")
public class HealthController {
    @RequestMapping("/health")
    public String health(){
        return "ok";
    }
}
