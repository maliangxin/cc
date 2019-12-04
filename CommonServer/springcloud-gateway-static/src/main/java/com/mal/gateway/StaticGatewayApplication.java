package com.mal.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = {"com.rxiu.gateway"})
public class StaticGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaticGatewayApplication.class, args);
    }

}
