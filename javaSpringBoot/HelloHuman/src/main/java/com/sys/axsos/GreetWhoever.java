package com.sys.axsos;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetWhoever {

@RequestMapping("/")
public String index(@RequestParam(value="n", required=false) String name,@RequestParam(value="s", required=false) String lastname) {
	if (name == null){
		return "hello human <br> welcome here";
	}
    return "<h1>Hello Mr "+ lastname +"</h1><p>We are happy to meet you "+ name +"</p>";
}

}