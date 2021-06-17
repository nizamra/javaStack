package com.sys.axsos;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	
		@RequestMapping("")
		public String toLogin(HttpSession sefoo) {
			if (sefoo.getAttribute("email") == null)
				return "index.jsp";
			return "redirect:/toShow";
			}
	
		@RequestMapping(value="/login", method= RequestMethod.POST)
		public String fromLogin(HttpSession sefoo,
							 @RequestParam(value="email") String mal,
							 @RequestParam(value="password") String pas	) {
			
			if(mal.equals("nizamra.95@gmail.com")&& pas.equals("System")) {
				if (sefoo.getAttribute("email") == null) {
					sefoo.setAttribute("email", mal);
					sefoo.setAttribute("pas", pas);
				}
				return "redirect:/toShow";
			}
			return "redirect:/";
		}
		
		@RequestMapping(value="/add_dojo", method= RequestMethod.POST)
		public String fromLoginForm(HttpSession sefoo,
				@RequestParam(value="name") String name,
				@RequestParam(value="fLang") String fLang,
				@RequestParam(value="comment") String comment,
				@RequestParam(value="dLocation") String dLocation	) {
			sefoo.setAttribute("name", name);
			sefoo.setAttribute("location", dLocation);
			sefoo.setAttribute("language", fLang);
			sefoo.setAttribute("comment", comment);
				return "redirect:/toShow";

		}
		
		 @RequestMapping("/toShow")
			public String toShow(HttpSession sefoo) {
//			 	if (sefoo.getAttribute("email") == null) 
//			 		return "redirect:/";
				return "show.jsp";
				}
		 
		 @RequestMapping("/logout")
		 public String tologout(HttpSession sefoo) {
			 if (sefoo.getAttribute("email") != null)
					sefoo.invalidate();
			 return "redirect:/";
		 }				 
	
}
