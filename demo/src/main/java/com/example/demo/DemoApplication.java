package com.example.demo;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
  * @author braska
  * @date 2018/06/25.
  **/
 @EnableAutoConfiguration
 @EnableZuulProxy
 @ComponentScan(basePackages = {
         "com.syher.zuul.core",
         "com.syher.zuul.service"
 })
 public class SpringBootZuulApplication implements CommandLineRunner {
     @Autowired
     ApplicationEventPublisher publisher;
     @Autowired
     RouteLocator routeLocator;

     private ScheduledExecutorService executor;
     private Long lastModified = 0L;
    private boolean instance = true;
 
   public static void main(String[] args) {
        SpringApplication.run(SpringBootZuulApplication.class, args);
     }
 
     @Override
     public void run(String... args) throws Exception {
         executor = Executors.newSingleThreadScheduledExecutor(
                 new ThreadFactoryBuilder().setNameFormat("properties read.").build()
         );
         executor.scheduleWithFixedDelay(() -> publish(), 0, 1, TimeUnit.SECONDS);
     }
 
     private void publish() {
         if (isPropertiesModified()) {
             publisher.publishEvent(new RoutesRefreshedEvent(routeLocator));
         }
     }

     private boolean isPropertiesModified() {
        File file = new File(this.getClass().getClassLoader().getResource(PropertiesRouter.PROPERTIES_FILE).getPath());
         if (instance) {
            instance = false;
             return false;
         }
         if (file.lastModified() > lastModified) {
             lastModified = file.lastModified();
            return true;
         }
         return false;
     }
 }