package com.yuyu.learnJandS.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yuyu.learnJandS.Form.MyForm;
import com.yuyu.learnJandS.Model.User;
import com.yuyu.learnJandS.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController implements WebMvcConfigurer {

	// @Autowired
	//// private MessageSource messageSource;
	//
	@Autowired
	private UserService userService;

	@GetMapping("/Demo1")
	// @ResponseBody
	public String firstMethod(Model model) {
		model.addAttribute("name", "yuyu");
		return "Demo";

		// User user = userService.getUserById(1);
		// model.addAttribute("user", user);
		// return "UserResult";
	}

	@GetMapping("/Main")
	// @ResponseBody
	public String mainPage(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "Main";
	}
	//
	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/Results").setViewName("Results");
	// }
	//
	// @GetMapping("/")
	// public String showForm(MyForm test) {
	// return "MyForm";
	// }
	//
	// @PostMapping("/")
	//// public String checkPersonInfo(@Valid MyForm myForm, BindingResult
	// bindingResult) {
	// public String checkPersonInfo(@Valid @ModelAttribute MyForm myForm,
	// BindingResult bindingResult, Model model) {
	//// model.addAttribute("nameText", messageSource.getMessage("nameText", null,
	// Locale.getDefault()));
	// if (bindingResult.hasErrors()) {
	// return "MyForm";
	// }
	//
	// return "redirect:/Results";
	// }
	//

}
