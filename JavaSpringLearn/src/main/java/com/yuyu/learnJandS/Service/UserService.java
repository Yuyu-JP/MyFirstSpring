package com.yuyu.learnJandS.Service;

import org.springframework.stereotype.Service;

import com.yuyu.learnJandS.Model.User;

public interface UserService {

	public User getUserById(Integer id);
	public int createUser(User user);
	public User getUserByName(String name);
}
