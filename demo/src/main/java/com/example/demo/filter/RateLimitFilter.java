package com.example.demo.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.syher.zuul.core.zuul.FilterOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class RateLimitFilter extends AbstractPreZuulFilter{
	
	

/**
* 每秒允许处理的量是50
 */
RateLimiter rateLimiter = RateLimiter.create(50);

 @Override
     public int filterOrder() {
         return FilterOrder.RATE_LIMITER_ORDER;
     }
	 
   @Override
     public Object doRun() {
         HttpServletRequest request = context.getRequest();
	         String url = request.getRequestURI();
	         if (rateLimiter.tryAcquire()) {
             return success();
	         } else {
	             LOGGER.info("rate limit:{}", url);
	            return fail(401, String.format("rate limit:{}", url));
	         }
	     }
	 }

}
