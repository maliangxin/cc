package com.rxiu.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@GetMapping("/hello.do")
	public String hello() {
		System.out.println("enter the hello  method");
		return "this is static gateway server";
	}

}
