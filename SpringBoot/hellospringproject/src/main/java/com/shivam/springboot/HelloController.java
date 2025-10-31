package com.shivam.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-controller")
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Springboot";
	}
	
	@GetMapping("/bye")
	public String goodbye() {
		return "Bye bye";
	}
}
