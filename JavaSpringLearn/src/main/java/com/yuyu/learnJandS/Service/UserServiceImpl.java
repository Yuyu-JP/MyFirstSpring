package com.yuyu.learnJandS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyu.learnJandS.Mapper.UserMapper;
import com.yuyu.learnJandS.Model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
//	public UserServiceImpl(UserMapper userMapper) {
//		this.userMapper = userMapper;
//	}
	
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}
	
	public int createUser(User user) {
		return userMapper.createUser(user.getName(), user.getPassword());
	}

}