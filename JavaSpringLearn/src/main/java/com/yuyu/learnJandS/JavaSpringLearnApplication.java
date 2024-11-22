package com.yuyu.learnJandS;

import java.util.Iterator;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.yuyu.learnJandS.dao.StudentDAO;
import com.yuyu.learnJandS.entity.Student;

@SpringBootApplication()
@MapperScan("com.yuyu.learnJandS.Mapper")
public class JavaSpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringLearnApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//		return runner -> {
//			createStudent(studentDAO);
//			queryStudent(studentDAO);
//			queryStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
//		};
//	}

//	private void deleteAll(StudentDAO studentDAO) {
//		studentDAO.deleteAll();
//	}
//
//	private void deleteStudent(StudentDAO studentDAO) {
//		studentDAO.deleteStudentById(2);
//	}
//
//	private void updateStudent(StudentDAO studentDAO) {
//		Student student = studentDAO.findById(3);
////		student.setLastName("Cao");
//		student.setId(1);
//		studentDAO.updateStudent(student);
		
//		for (int i = 3; i < 6; i++) {
//			Student student = studentDAO.findById(i);
//			student.setId(i - 2);
//			studentDAO.updateStudent(student);
//		}
//	}
//
//	private void queryStudentByLastName(StudentDAO studentDAO) {
//		List<Student> students = studentDAO.getStudentsByLastName("Zhao");
//		for (Student student : students) {
//			System.out.println(student);
//		}
//	}
//
//	private void queryStudent(StudentDAO studentDAO) {
//		List<Student> students = studentDAO.getAllStudents();
//		for (Student student : students) {
//			System.out.println(student);
//		}
//	}
//
//	private void createStudent(StudentDAO studentDAO) {
//		System.out.println("create student object");
//		Student tmpStudent = new Student("Yuyu", "Zhao", "zyy@test.com");
//		Student tmpStudent2 = new Student("Paul", "Scholes", "paul@test.com");
//		Student tmpStudent3 = new Student("Steve", "Kelvein", "Steve@test.com");
//
//		studentDAO.save(tmpStudent);
//		studentDAO.save(tmpStudent2);
//		studentDAO.save(tmpStudent3);
//	}
}
