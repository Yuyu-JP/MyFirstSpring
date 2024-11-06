package com.yuyu.learnJandS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yuyu.learnJandS.MyForm.MyForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class DemoController implements WebMvcConfigurer{
	
	@Autowired
	private MessageSource messageSource;
	
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
	public String showForm(MyForm test) {
		return "MyForm";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid Model model, BindingResult bindingResult) {
		model.addAttribute("MyForm", "myForm");
		model.addAttribute("nameText", messageSource.getMessage("nameText", null, Locale.getDefault()));
		if (bindingResult.hasErrors()) {
			return "MyForm";
		}
		
		return "redirect:/Results";
	}
	
	
}
