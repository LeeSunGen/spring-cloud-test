package com.itmuch.cloud.study.commodity;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableSwagger2Doc
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class CommodityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommodityApplication.class, args);
    }
}
