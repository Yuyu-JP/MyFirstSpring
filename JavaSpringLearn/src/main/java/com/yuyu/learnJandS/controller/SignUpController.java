package com.yuyu.learnJandS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuyu.learnJandS.Form.CreateUserForm;
import com.yuyu.learnJandS.Model.User;
import com.yuyu.learnJandS.Service.UserService;
import com.yuyu.learnJandS.Utils.EncryptUtil;

import jakarta.validation.Valid;

@Controller
public class SignUpController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/signUp")
	public String getUserById(CreateUserForm createUserForm, Model model) {
		model.addAttribute("isExisted", false);
		return "SignUp";
	}

	@PostMapping("/signUp")
	public String createUser(@Valid CreateUserForm createUserForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "SignUp";
		}
		
		boolean isExisted = userService.getUserByName(createUserForm.getName()) != null;
		
		if (isExisted) {
			model.addAttribute("isExisted", isExisted);
			return "SignUp";
		}
		
		User user = new User();
		user.setName(createUserForm.getName());
		String hash = EncryptUtil.hash(createUserForm.getPassword());
		user.setPassword(hash);
		user.setRole("ADMIN");
		userService.createUser(user);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/CreateUserResult";
	}
}
