package com.yuyu.learnJandS.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.yuyu.learnJandS.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final CustomUserDetailsService customUserDetailsService;
	
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/signUp", "/ajaxDemo", "/js/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/RestDemo", "/api/submitData").permitAll()
				.anyRequest().authenticated()

			)
			.formLogin((form) -> form
				.loginPage("/Login")
				.defaultSuccessUrl("/Main", true)
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			.csrf((csrf) -> csrf.disable());

		return http.build();
	}

//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
        // This will store passwords in plain text
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new BCryptPasswordEncoder();
    }
	
	@Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(customUserDetailsService)
                   .passwordEncoder(passwordEncoder())
                   .and()
                   .build();
    }
}