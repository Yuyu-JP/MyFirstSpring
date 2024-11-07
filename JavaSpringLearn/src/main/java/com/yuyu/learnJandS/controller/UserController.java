package com.yuyu.learnJandS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yuyu.learnJandS.Model.User;
import com.yuyu.learnJandS.Service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser1")
    public String getUserById(Model model) {
		User user = userService.getUserById(1);
//		model.addAttribute("name", user.getName());
//		model.addAttribute("password", user.getPassword());
		model.addAttribute("user", user);
        return "UserResult";
    }
	
	@PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
