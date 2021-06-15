package com.sys.axsos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AxTesting {

@RequestMapping("/axsos")
public String printing(){
	return "axsos sometheng do";
}

@RequestMapping("/{Hadeel}")
	public String showLesson(@PathVariable("Hadeel") String HerName){
	
	if (HerName.equals("ram-allah")) {
		return "ram-allah is where the headquarters are located";
		} else if (HerName.equals("burbank-axsos")) {
			return "Burbank Dojo is located in Southern California";
		} else {
			return "HerName is going to be here for you: " + HerName ;
		}
	
	}

}