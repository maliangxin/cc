package com.dynamic.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@GetMapping("/hello.do")
	public String hello() {
		return "this is gateway server";
	}

}
