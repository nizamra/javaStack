package com.sys.axsos.controllerForCountries;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sys.axsos.services.ServingCountries;

@Controller
public class ControlingAllCountries {
	private final ServingCountries ServerAlaa;
	
	public ControlingAllCountries(ServingCountries habal) {
		ServerAlaa = habal;
	}
	
	@GetMapping("/")
	public String index(Model someModel, HttpSession someSession) {
		someModel.addAttribute("wholeWorld", ServerAlaa.findAllCountries());
		return "index.jsp";
	}

}
