package com.example.demo.controller;
 
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class GetController {
 
	@GetMapping("signUp")
	public String showSignUpForm() {
		return "signUp.html";
	}
 
	@PostMapping("register")
	public String registerUser(@RequestParam("name") String name, @RequestParam("birth") LocalDate birth, Model model) {
 
		model.addAttribute("name", name);
		model.addAttribute("birth", birth);
 
		return "register.html";
	}
}
