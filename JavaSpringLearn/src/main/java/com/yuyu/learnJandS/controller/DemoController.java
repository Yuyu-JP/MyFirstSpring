package com.yuyu.learnJandS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yuyu.learnJandS.MyForm.MyForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class DemoController implements WebMvcConfigurer{
	
	@GetMapping("/Demo")
//	@ResponseBody
	public String firstMethod(Model model) {
		model.addAttribute("name", "yuyu");
		return "Demo";
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/Results").setViewName("Results");
	}
	
	@GetMapping("/")
	public String showForm(MyForm myform) {
		return "MyForm";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid MyForm myform, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "MyForm";
		}
		
		return "redirect:/Results";
	}
	
	
}
