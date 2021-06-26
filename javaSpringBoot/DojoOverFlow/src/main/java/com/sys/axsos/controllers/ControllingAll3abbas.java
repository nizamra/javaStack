package com.sys.axsos.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String main(Model Hawwash) {
		Hawwash.addAttribute("kolesso2alat", Abdullah.findQuestions());
		return "questions.jsp";
	}

	@GetMapping("/question/new")
	public String show(@ModelAttribute("amal") Question question) {
		return "new.jsp";
	}

//	Field 'tag' doesn't have a default value
	@PostMapping("/question/create")
	public String questionCreate(@RequestParam("tagss") String someTags, @Valid @ModelAttribute("amal") Question sanad,
			BindingResult result) {
		System.out.println("we are mapping starter falafel");
		if (result.hasErrors()) {
			System.out.println("we are with errors");
			return "new.jsp";
		}
		Abdullah.createQuestion(sanad);
		List<String> dalbah = Arrays.asList(someTags.split(","));
		System.out.println("we are here abdullah");

		for (String variableName : dalbah) {
			System.out.println("we are here in the for");

			if(Abdullah.findTagNamed(variableName) != null) {
				System.out.println("we are in the ifff");
			  QuestionsTags newLine = new QuestionsTags();
			  
			  newLine.setTag(Abdullah.findTagNamed(variableName));
			  newLine.setQuestion(Abdullah.createQuestion(sanad));
			  Abdullah.createMostafa(newLine);
          }else {
        	  System.out.println("we are in the elsingintion");
        	  Tag taggingQ = new Tag();
        	  System.out.println("we have created a new tag");
        	  taggingQ.setSubject(variableName);        	  
        	  System.out.println(taggingQ.toString());
        	  System.out.println("setting the new tags subject");
        	  Abdullah.createtag(taggingQ);
        	  System.out.println("we saved the tag for you");
        	  QuestionsTags newLine = new QuestionsTags();
        	  System.out.println("creating the relation");
			  newLine.setTag(taggingQ);
			  newLine.setQuestion(sanad);
			  Abdullah.createMostafa(newLine);
          }
		}
		return "redirect:/";
	}
//	public void tagCheckAndSave(List<String> tags, Question question) {
//        Question saveQuestion = saveQuestion(question);
//        for(String check : tags) {
//            if(findSpecificTagbyName(check) != null) {
//                TagQuestion combine = new TagQuestion();
//                combine.setTag(findSpecificTagbyName(check));
//                combine.setQuestion(saveQuestion);
//                saveTagQuestion(combine);
//            }
//            else {
//                Tag newTag = new Tag();
//                newTag.setSubject(check);
//                Tag cTag = saveTag(newTag);
//                TagQuestion combine = new TagQuestion();
//                combine.setTag(cTag);
//                combine.setQuestion(saveQuestion);
//                saveTagQuestion(combine);
//            }
//        }
//    }
}
