package com.chat;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
 
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.chat"})
public class AppMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppMain.class).web(true).run(args);
    }
}