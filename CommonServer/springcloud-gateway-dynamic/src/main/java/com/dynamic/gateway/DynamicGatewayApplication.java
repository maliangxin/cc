package com.dynamic.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = {"com.dynamic.gateway"})
@EnableEurekaClient
public class DynamicGatewayApplication {
            
    public static void main(String[] args) {
        SpringApplication.run(DynamicGatewayApplication.class, args);
    }

}
