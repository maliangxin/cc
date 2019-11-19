package com;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
 
@SpringBootApplication //spring-boot 启动注解
@EnableEurekaServer // spring-cloud 服务注解
public class RegisterMain{
     public static void main(String [] args) {
    	 new SpringApplicationBuilder(RegisterMain.class).web(true).run(args);
     }
}