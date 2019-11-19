package com.mal.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {
	
	@GetMapping("/logback.do")
	public void printinfo() {
		
	}

}
