package com.itmuch.cloud.study.account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class HealthController {
    @RequestMapping("/health")
    public String health(){
        return "ok";
    }
}
