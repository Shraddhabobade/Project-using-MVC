package com.tka.DemoMVC1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tka.DemoMVC1.entity.User1;
import com.tka.DemoMVC1.service.UserService;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {

	@Autowired
	UserService service;
	
	@PostMapping("/login")
	public String checkUser(@ModelAttribute User1 user,Model model) {
		System.out.println("U r in login API ");
		System.out.println(user);
		String msg = service.checkUser(user);
		
		if(msg.equalsIgnoreCase("valid user")) {
			return "home";
		}else {
			model.addAttribute("msg", "Invalid User");
			return "login";
		}
		
		
	}
}
