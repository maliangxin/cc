package com.mal.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2Controller {

	@GetMapping("/log4j.do")
	public void printinfo() {
		
	}
	
}
