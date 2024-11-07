package com.yuyu.learnJandS.Mapper;
import org.apache.ibatis.annotations.Mapper;

import com.yuyu.learnJandS.Model.User;

@Mapper
public interface UserMapper {
	public int createUser(String username, String password);
	public User getUserById(Integer id);
}
