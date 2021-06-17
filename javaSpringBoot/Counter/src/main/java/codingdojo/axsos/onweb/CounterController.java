package codingdojo.axsos.onweb;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
private static int con=0;
	@RequestMapping("/")
	public String mainLoad(HttpSession session){
		con+=1;
        session.setAttribute("count", con);        
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String lol() {
		return "counter.jsp";
	}

	
}
