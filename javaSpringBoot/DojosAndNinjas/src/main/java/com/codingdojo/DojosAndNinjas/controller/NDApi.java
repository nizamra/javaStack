package com.codingdojo.DojosAndNinjas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.services.NDService;


@Controller
public class NDApi {
private final NDService NDS;

public NDApi(NDService nDS) {
	NDS = nDS;
}
@RequestMapping("/dojos/new")
public String dNew(@ModelAttribute("Dojo") Dojo Dojo) {
	return "/ninjas/newDojo.jsp";
}
@RequestMapping("/dojos")
public String create(@Valid @ModelAttribute("Dojo") Dojo x, BindingResult result) {
    if (result.hasErrors()) {
        return "/relationships/newDojo.jsp";
    } else {
    	NDS.createDojo(x);
        return "redirect:/";
    }

	  }
@RequestMapping("/ninjas/new")
public String nNew(@ModelAttribute("Ninja") Ninja Ninja,Model model) {
	List <Dojo> x=NDS.findAllDojos();
	model.addAttribute("x",x);
	return "/ninjas/newNinja.jsp";
}
@RequestMapping("/ninjas")
public String create(@Valid @ModelAttribute("Ninja") Ninja x, BindingResult result) {
    if (result.hasErrors()) {
        return "/relationships/newNinja.jsp";
    } else {
    	NDS.createNinja(x);
        return "redirect:/";
    }

	  }
@RequestMapping("/dojos/{id}")
public String show(@PathVariable("id") long id,Model model) {
	Dojo x=NDS.findDojoById(id);
	List <Ninja> xg=NDS.findAllByDojo(x);
	model.addAttribute("x",x);
	model.addAttribute("xg",xg);
	return "/ninjas/dojos.jsp";
}
}
