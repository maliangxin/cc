package com.mal.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
	
	@Autowired
	StringRedisTemplate template;
	
	@GetMapping("/get.do")
	public String getRedisValue(@RequestParam("key") String key) {
		String res = template.opsForValue().get(key);
		return res;
	}

}
