package com.itmuch.cloud.study.gateway;

import com.google.common.collect.Lists;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
@EnableDiscoveryClient
@EnableWebSecurity
@EnableOAuth2Client
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }



    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = Lists.newArrayList();
            resources.add(swaggerResource("order-service", "/api/order/v2/api-docs", "2.0"));
            resources.add(swaggerResource("commodity-service", "/api/commodity/v2/api-docs", "2.0"));
            resources.add(swaggerResource("payment-service", "/api/payment/v2/api-docs", "2.0"));
            resources.add(swaggerResource("account-service", "/api/account/v2/api-docs", "2.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
