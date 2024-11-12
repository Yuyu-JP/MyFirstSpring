package com.yuyu.learnJandS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yuyu.learnJandS.Form.CreateUserForm;
import com.yuyu.learnJandS.Form.UserForm;
import com.yuyu.learnJandS.Model.User;
import com.yuyu.learnJandS.Service.UserService;
import com.yuyu.learnJandS.Service.UserServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/SearchUser")
	public String getUserById(UserForm userForm, Model model) {
		model.addAttribute("notExist", false);
		return "SearchForm";
	}

	@PostMapping("/SearchUser")
	public String searchUser(@Valid UserForm userForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "SearchForm";
		}
		User user = userService.getUserById(userForm.getId());
		if (user != null) {
			redirectAttributes.addFlashAttribute("user", user);
		} else {
			model.addAttribute("notExist", true);
			return "SearchForm";
		}
		return "redirect:/UserResult";
	}

	@GetMapping("/UserResult")
	public String showUserResult(Model model) {
		if (model.containsAttribute("user")) {
			User user = (User) model.getAttribute("user");
		}
		return "UserResult";
	}

	@GetMapping("/CreateUser")
	public String getUserById(CreateUserForm createUserForm, Model model) {
		model.addAttribute("isExisted", false);
		return "CreateUserForm";
	}

	@PostMapping("/CreateUser")
	public String createUser(@Valid CreateUserForm createUserForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "CreateUserForm";
		}

		boolean isExisted = userService.getUserByName(createUserForm.getName()) != null;

		if (isExisted) {
			model.addAttribute("isExisted", isExisted);
			return "CreateUserForm";
		}

		User user = new User();
		user.setName(createUserForm.getName());
		user.setPassword(createUserForm.getPassword());
		user.setRole("ADMIN");
		userService.createUser(user);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/CreateUserResult";
	}

	@GetMapping("/CreateUserResult")
	public String showCreateUserResult(Model model) {
		if (model.containsAttribute("user")) {
			User user = (User) model.getAttribute("user");
		}
		return "CreateUserResult";
	}

	@GetMapping("/Login")
	public String showLogin() {
		return "Login";
	}

}
