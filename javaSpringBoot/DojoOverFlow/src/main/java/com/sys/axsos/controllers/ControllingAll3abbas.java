package com.sys.axsos.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sys.axsos.models.Answer;
import com.sys.axsos.models.Question;
import com.sys.axsos.models.QuestionsTags;
import com.sys.axsos.models.Tag;
import com.sys.axsos.servieces.ServicingStackAsd;

@Controller
public class ControllingAll3abbas {
	private final ServicingStackAsd Abdullah;

	public ControllingAll3abbas(ServicingStackAsd Qawasems) {
		Abdullah = Qawasems;
	}

	@GetMapping("/")
	public String redirectingyou() {
		return "redirect:/questions";
	}

	@GetMapping("/questions")
	public String main(Model model) {
		model.addAttribute("kolesso2alat", Abdullah.findQuestions());
		return "questions.jsp";
	}

	@GetMapping("/question/new")
	public String show(@ModelAttribute("amal") Question question) {
		return "new.jsp";
	}

	@PostMapping("/question/create")
	public String questionCreate(@RequestParam("tagss") String someTags, @Valid @ModelAttribute("amal") Question sanad,
			BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
//		Question SandraBullock = new Question();
//		SandraBullock.setQuestion(sanad.getQuestion());
		Abdullah.createQuestion(sanad);
		List<String> dalbah = Arrays.asList(someTags.split(","));

		for (String variableName : dalbah) {
			if(Abdullah.findTagNamed(variableName) != null) {
			  QuestionsTags newLine = new QuestionsTags();
			  newLine.setTag(Abdullah.findTagNamed(variableName));
			  newLine.setQuestion(Abdullah.createQuestion(sanad));
			  Abdullah.createQuestionsTags(newLine);
          }else {
        	  Tag taggingQ = new Tag();
        	  taggingQ.setSubject(variableName);
        	  Abdullah.createTag(taggingQ);
        	  QuestionsTags newLine = new QuestionsTags();
			  newLine.setTag(taggingQ);
			  newLine.setQuestion(sanad);
			  Abdullah.createQuestionsTags(newLine);
          }
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/question/{questionNumber}")
	public String thisExactQuestion(Model model,@PathVariable("questionNumber") Long num,@ModelAttribute("sarab") Answer anas) {
		model.addAttribute("so2alak", Abdullah.findById(num));
		return "su2al.jsp";
	}
	@PostMapping("/answer/create/{changeable}")
	public String answerCreate(@Valid @ModelAttribute("sarab") Answer anas, BindingResult result, @PathVariable("changeable") Long num,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("so2alak", Abdullah.findById(num));
			return "su2al.jsp";
		}
		anas.setQuestion(Abdullah.findById(num));
		Abdullah.createMostafa(anas);
		return "redirect:/";
	}
	

}
