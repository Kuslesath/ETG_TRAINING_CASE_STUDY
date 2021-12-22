package com.sonata.springMvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("user", "command", new User());
	   }
	
	@RequestMapping(value = "/user1", method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("User")User u,/*BindingResult result, */ModelMap model) {
		
		/*model.addAttribute("User", u);*/
			
			int row=0;
			userDaoImpl d= new userDaoImpl();
			row = d.save(u);
			
			if(row!=0) {
				return "successUser";
			}
			else
				return "failureUser";
	   }
}
