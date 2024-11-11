package com.yuyu.learnJandS;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
@MapperScan("com.yuyu.learnJandS.Mapper")
public class JavaSpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringLearnApplication.class, args);
	}

}
