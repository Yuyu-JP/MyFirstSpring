package com.yuyu.learnJandS.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restdemo")
public class DemoRestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, world!";
	}
	
	@GetMapping("/RestDemo")
	public Map<String, String> showDemoPage() {
		Map<String, String> response = new HashMap<>();
	        response.put("message", "Hello, RestDemo!");
		return response;
	}
	
	@PostMapping("/RestDemo")
	public Map<String, String> demoMethod() {
		Map<String, String> response = new HashMap<>();
	        response.put("message", "Hello, RestDemo!");
		return response;
	}
}
