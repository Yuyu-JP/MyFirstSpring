package com.yuyu.learnJandS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yuyu.learnJandS.Model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user in the database
        User user = userService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        UserDetails userdetails =
        		org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
   				.username(user.getName())
   				.password(user.getPassword())
   				.roles(user.getRole())
   				.build();
        
        return userdetails;
    }
}
