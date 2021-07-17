package com.sys.axsos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sys.axsos.models.Course;
import com.sys.axsos.models.Guest;
import com.sys.axsos.models.LoginGuest;
import com.sys.axsos.services.Servs;

@Controller
public class ControleExam {
	private final Servs serverForBeltExam;

	public ControleExam(Servs habal) {
		serverForBeltExam = habal;
	}

	@PostMapping("/courses/new")
	public String create(@Valid @ModelAttribute("course") Course newCourse, BindingResult res) {
		if(res.hasErrors()) {
			return "courses.jsp";
		}
		serverForBeltExam.create(newCourse);
		return "redirect:/courses";	

	}

	@RequestMapping("/courses/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return "newCourse.jsp";
	}
	@RequestMapping("/courses/delete/{courseid}")
	public String destroyCourse(@PathVariable("courseid") long courseid,@ModelAttribute("course") Course course) {
		serverForBeltExam.destroy(serverForBeltExam.getMeACourse(courseid));
		return "redirect:/";
	}

	@RequestMapping("/courses/{id}/add")
	public String addToEvent(@PathVariable("id") long id, HttpSession session, Model contextPythoning) {
		Long joiningUserID = (Long) session.getAttribute("Guest_id");
		serverForBeltExam.joinTheCourse(id, joiningUserID);
		return "redirect:/courses/{id}";
	}

	@RequestMapping("/courses/{id}")
	public String showEvent(@PathVariable("id") long id, Model contextPythoning, HttpSession jalasatWanasah) {
		Long omarna = (Long) jalasatWanasah.getAttribute("Guest_id");
		contextPythoning.addAttribute("theLogedInUser", serverForBeltExam.gettingGuest(omarna));
		contextPythoning.addAttribute("course", (Course)serverForBeltExam.find(id));
		return "showCourse.jsp";
	}
	@RequestMapping("/courses/{id}/edit")
	public String editPage(@ModelAttribute("course") Course myCourse, @PathVariable("id") Long myId, Model model) {
		Course course = serverForBeltExam.getMeACourse(myId);
		model.addAttribute("course", course);
		return "edit.jsp";
	}

	@RequestMapping("/courses/{coursd}/remove")
	public String removeuser(@PathVariable("coursd") long id, HttpSession session, Model contextPythoning) {
		Long joiningUserID = (Long) session.getAttribute("Guest_id");
		serverForBeltExam.removeuser(id, joiningUserID);
		return "redirect:/";
	}

	@PostMapping("/courses/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course myCourse, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			List<Guest> myStudents =myCourse.getGuests();
			myCourse.setGuests(myStudents);
			serverForBeltExam.updateCourse(myCourse);
			return "redirect:/";
		}
	}

	// @RequestMapping(value = {"/", "/home"})
	@GetMapping("/")
	public String index(@ModelAttribute("newGuest") Guest abdulrahmanGouli,
			@ModelAttribute("newLogin") LoginGuest mohannadSalman, Model contextPythoning, HttpSession jalasatWanasah) {
		if (jalasatWanasah.getAttribute("Guest_id") != null) {
			return "redirect:/courses";
		}
		return "home.jsp";
	}

	@PostMapping(value = "/register")
	public String createGuest(@Valid @ModelAttribute("newGuest") Guest xXx, BindingResult result,
			Model contextPythoning, @ModelAttribute("newLogin") LoginGuest mohannadSalman, HttpSession jalasatWanasah) {
		serverForBeltExam.registering(xXx, result);
		if (result.hasErrors()) {
			contextPythoning.addAttribute("newLogin", new LoginGuest());
			return "home.jsp";
		} else {
			jalasatWanasah.setAttribute("Guest_id", xXx.getId());
			return "redirect:/";
		}
	}

	@PostMapping("/login")
	public String loginGuest(@Valid @ModelAttribute("newLogin") LoginGuest someoneLogging, BindingResult result,
			Model contextPythoning, @ModelAttribute("newGuest") Guest abdulrahmanGouli, HttpSession jalasatWanasah) {
		Guest someGuest = serverForBeltExam.login(someoneLogging, result);
		if (result.hasErrors()) {
			contextPythoning.addAttribute("newGuest", new Guest());
			return "home.jsp";
		}
		jalasatWanasah.setAttribute("Guest_id", someGuest.getId());
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession jalasatWanasah) {
		jalasatWanasah.invalidate();
		return "redirect:/";
	}

	@GetMapping("/courses")
	public String indexing(@ModelAttribute("course") Course course,Model contextPythoning, HttpSession jalasatWanasah) {
		if (jalasatWanasah.getAttribute("Guest_id") != null) {
			Long omarna = (Long) jalasatWanasah.getAttribute("Guest_id");
			contextPythoning.addAttribute("theLogedInUser", serverForBeltExam.gettingGuest(omarna));
			// ArrayList<Course> courses = serverForBeltExam.all();
			contextPythoning.addAttribute("courses", serverForBeltExam.all());
			System.out.println(serverForBeltExam.gettingGuest(omarna));
			return "courses.jsp";
		}
		return "redirect:/";
	}
	@GetMapping("/courses/order")
	public String orderindex(@ModelAttribute("course") Course course,Model contextPythoning, HttpSession jalasatWanasah) {
		if (jalasatWanasah.getAttribute("Guest_id") != null) {
			Long omarna = (Long) jalasatWanasah.getAttribute("Guest_id");
			contextPythoning.addAttribute("theLogedInUser", serverForBeltExam.gettingGuest(omarna));
			// ArrayList<Course> courses = serverForBeltExam.all();
			contextPythoning.addAttribute("coursesdesc", serverForBeltExam.alldesending());
			System.out.println(serverForBeltExam.gettingGuest(omarna));
			return "coursesorder.jsp";
		}
		return "redirect:/";
	}

}
