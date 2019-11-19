package com.example.demo.filter;

 import com.netflix.loadbalancer.IRule;
 import com.netflix.zuul.ZuulFilter;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.autoconfigure.web.ServerProperties;
 import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

@Configuration
 public class ZuulConfigure {
 
     @Autowired
     ZuulProperties zuulProperties;
    @Autowired
     ServerProperties server;
 
    /**
      * 动态路由
     * @return
      */
     @Bean
     public PropertiesRouter propertiesRouter() {
         return new PropertiesRouter(this.server.getServletPrefix(), this.zuulProperties);
     }
 
     /**
      * 动态负载
      * @return
     */
     @Bean
     public IRule loadBalance() {
         return new ServerLoadBalancerRule();
     }
 
     /**
      * 自定义过滤器
      * @return
      */
     @Bean
     public ZuulFilter rateLimiterFilter() {
         return new RateLimiterFilter();
     }
 }
