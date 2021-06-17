package com.sys.axsos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Goldss {

	

//	commenss.add(comments.size(),"You entered " +place+ " and earned "+amount+" of gold");
	public static int goldValue = 0;
	ArrayList<String> arr = new ArrayList<String>();
	
	@RequestMapping(value="/addGold", method= RequestMethod.POST)
	public String fromGoldForm(HttpSession sefoodes){
		
		sefoodes.setAttribute("goldValue", goldValue);
		return "redirect:/toNinjaGold";
		
	}
	
	@RequestMapping("/toNinjaGold")
	public String toNinjaGold(HttpSession sefoodes) {
		sefoodes.setAttribute("gold", goldValue);
		sefoodes.setAttribute("arr", arr);
		sefoodes.setAttribute("size", arr.size());
		return "ninjaGold.jsp";
	}

	@RequestMapping(value = "/lol", method = RequestMethod.POST)
    public String manPage(HttpSession session, @RequestParam(value = "goldInput") String val) {
        if (val.equals("1")) {
            int min = 1;
            int max = 20;
            int ran = (int) Math.floor(Math.random() * (max - min + 1) + min);
            goldValue += ran;
            arr.add("You entered Army and earned "+ran+" of gold"+ new Date());
            }
        if (val.equals("2")) {

            Random r = new Random();
            int min = 100;
            int max = 150;
            int x = r.nextInt(2);
            if (x == 1) {
                int ran = (int) Math.floor(Math.random() * (max - min + 1) + min);
                goldValue += ran;
                arr.add("You entered Army and earned "+ran+" of gold"+ new Date());
            }

        }
        if (val.equals("3")) {
            int min = 5;
            int max = 10;
            int ran = (int) Math.floor(Math.random() * (max - min + 1) + min);
            goldValue -= ran;
            arr.add("You entered Army and lost "+ran+" of gold"+ new Date());

        }
        if (val.equals("4")) {
            int min = 50;
            int max = 100;
            int ran = (int) Math.floor(Math.random() * (max - min + 1) + min);
            goldValue -= ran;
            arr.add("You entered Army and lost "+ran+" of gold"+ new Date());
        }
        session.setAttribute("gold", goldValue);
        return "redirect:/toNinjaGold";
    }

    
}
