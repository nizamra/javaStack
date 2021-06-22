package com.codingdojo.relationships.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.relationService;
@Controller
public class RelationApi {
private final relationService rs;

public RelationApi(relationService rs) {
	this.rs = rs;
}
@RequestMapping("/persons/new")
public String newPerson(@ModelAttribute("Person") Person Person) {
	return "/relationships/newPerson.jsp";
}
@RequestMapping("/")
public String def(Model model) {
	List <Person> x=rs.allPerson();
	List <License> xg=rs.allLicense();
	model.addAttribute("x",x);
	model.addAttribute("xg",xg);
	return "/relationships/def.jsp";
}
@RequestMapping(value="/person",method=RequestMethod.POST)
public String create(@Valid @ModelAttribute("Person") Person x, BindingResult result) {
    if (result.hasErrors()) {
        return "/relationships/newPerson.jsp";
    } else {
    	rs.createPerson(x);
        return "redirect:/";
    }

	  }
@RequestMapping("/licenses/new")
public String newLicense(@ModelAttribute("License") License License,Model model) {
	List<Person> x=rs.allPerson();
	model.addAttribute("x",x);
	return "/relationships/newLicense.jsp";
}
@RequestMapping("/license")
public String createL(@Valid @ModelAttribute("License") License x,BindingResult result) {
    if (result.hasErrors()) {
        return "/relationships/newPerson.jsp";
    } else {
    	rs.createLicense(x);
        return "redirect:/";
    }
}
}
