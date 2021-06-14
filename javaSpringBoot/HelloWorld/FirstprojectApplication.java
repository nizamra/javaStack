package com.axsos.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	
	@RequestMapping("/")
	public String Hello(){
		return "Hello Client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String Hello2(){
		return "something to do with the copy and pasting algos HAHAHAHAAAAA...";
	}

}
