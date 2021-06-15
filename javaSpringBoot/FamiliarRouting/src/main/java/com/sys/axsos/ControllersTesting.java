package com.sys.axsos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class ControllersTesting {
	
	@RequestMapping("")
	public String Hello(){
		return "Hello dear! How are you doing today?";
	}
	
	@RequestMapping("/python")
	public String python(){
		return "something to do with the Python/Django where it really was awesome!";
	}
	@RequestMapping("/java")
	public String java(){
		return "They say Java/Spring is better! don't know yet";
	}
}
