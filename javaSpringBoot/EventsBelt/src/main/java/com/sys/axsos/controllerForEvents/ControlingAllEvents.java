package com.sys.axsos.controllerForEvents;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.sys.axsos.models.Event;
import com.sys.axsos.models.LoginUser;
import com.sys.axsos.models.MesComment;
import com.sys.axsos.models.User;
import com.sys.axsos.services.ServingEvents;

@Controller
public class ControlingAllEvents {
	private final ServingEvents serverOfMyEvents;

	public ControlingAllEvents(ServingEvents habal) {
		serverOfMyEvents = habal;
	}

	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User abdulrahmanGouli,
			@ModelAttribute("newLogin") LoginUser mohannadSalman,@ModelAttribute("newEvent") Event barood, Model contextPythoning, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			return "redirect:/everyEventsx";
		}
		return "home.jsp";
	}
	
	@PostMapping(value = "/register")
	public String createuser(@Valid @ModelAttribute("newUser") User xXx, BindingResult result, Model contextPythoning,
			HttpSession session) {
		serverOfMyEvents.registering(xXx, result);
		if (result.hasErrors()) {
			contextPythoning.addAttribute("newUser", new User());
			return "home.jsp";
		} else {
			session.setAttribute("user_id", xXx.getId());
			return "redirect:/";
		}
	}

	@PostMapping("/login")
	public String loginuser(@Valid @ModelAttribute("newLogin") LoginUser someoneLogging, BindingResult result,
			Model contextPythoning, HttpSession session) {
		User someuser = serverOfMyEvents.login(someoneLogging, result);
		if (result.hasErrors()) {
			contextPythoning.addAttribute("newUser", new User());
			return "home.jsp";
		}
		session.setAttribute("user_id", someuser.getId());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/everyEventsx")
	public String index(@ModelAttribute("newEvent") Event barood, Model contextPythoning, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Long omarna = (Long) session.getAttribute("user_id");
			contextPythoning.addAttribute("theLogedInUser", serverOfMyEvents.gettingUser(omarna));
			
			contextPythoning.addAttribute("kolelEventatMish3indak",
					serverOfMyEvents.getkolelEventatMish3indak(omarna));
			contextPythoning.addAttribute("kolelEventat3indak",
					serverOfMyEvents.getkolelEventat3indak(omarna));
			return "events.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/event/new")
	public String createNewEvent(@Valid @ModelAttribute("newEvent") Event someEvent,
			BindingResult result,
			Model contextPythoning, HttpSession session) {
		Long thisIsUserId = (Long) session.getAttribute("user_id");
		serverOfMyEvents.singEvent(someEvent, thisIsUserId);
		if (result.hasErrors()) {
			return "events.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/show/event/{nizar_id}")
	public String showEvent(@PathVariable("nizar_id") Long nizaRid, @ModelAttribute("commentCreation") MesComment commentCreation, HttpSession session, Model contextPythoning) {
		Event SomeEvent = serverOfMyEvents.getMeSomeEvent(nizaRid);
		contextPythoning.addAttribute("thisSomeEventinstance", SomeEvent);
		Long omarnaIDD = (Long) session.getAttribute("user_id");
		contextPythoning.addAttribute("theLogedInUser", serverOfMyEvents.gettingUser(omarnaIDD));
		return "eventcomments.jsp";
	}
	
    @PostMapping("/newCommentCreation")
    public String createComment(@Valid @ModelAttribute("commentCreation") MesComment commentCreation, BindingResult result) {
    	if (result.hasErrors()) {
    		System.out.println("print this if theres an error");
    		System.out.println(result.toString());
    		return "eventcomments.jsp";
//            return "redirect:/show/event/" + idOfThisEvent;
        }
    	else {System.out.println("try to create");
    		serverOfMyEvents.createNewComment(commentCreation);System.out.println("Done creating");
    		return "redirect:/";
//    		return "redirect:/show/event/"+commentCreation.getEvent().getId();
    	}
    }
	
    @RequestMapping("/join/event/{id}")
    public String joinEvent(@PathVariable("id") Long id,HttpSession session) {
    	Long joiningUserID = (Long) session.getAttribute("user_id");
    	serverOfMyEvents.joinTheEvent(id, joiningUserID);
    	return "redirect:/show/event/"+id;
    }
	
    @RequestMapping("/edit/event/{nizaR}")
    public String editEvent(@Valid @ModelAttribute("wxyz") Event Event, BindingResult result, @PathVariable("nizaR") Long nizaR,Model model) {
    	Event SomeEvent = serverOfMyEvents.getMeSomeEvent(nizaR);
    	model.addAttribute("SomeEvent",SomeEvent);
    	return "edit.jsp";
    }
    @RequestMapping(value="/editevents/{id}")
    public String update(@Valid @ModelAttribute("wxyz") Event Event, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	serverOfMyEvents.updateEvent(Event);
            return "redirect:/";
        }
    }
//    @RequestMapping("/songs/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//   	 Song songinstance = songrepositoryinstance.findsonginstance(id);
//        model.addAttribute("songinstance", songinstance);
//        return "edit.jsp";
//    }
//    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
//    public String update(@Valid @ModelAttribute("songinstance") Song songinstance, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//       	 songrepositoryinstance.updatesonginstance(songinstance);
//            return "redirect:/";
//        }
//    }
    
    @RequestMapping("/delete/event/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
    	serverOfMyEvents.deleteAnEventById(id);
    	 return "redirect:/";
    }
	
    @RequestMapping("/cancel/event/{id}")
    public String cancelEvent(@PathVariable("id") Long id,HttpSession session) {
    	Long cancellingUserID = (Long) session.getAttribute("user_id");
    	serverOfMyEvents.cancelevent(id, cancellingUserID);
    	return "redirect:/";
    }    
	
}
