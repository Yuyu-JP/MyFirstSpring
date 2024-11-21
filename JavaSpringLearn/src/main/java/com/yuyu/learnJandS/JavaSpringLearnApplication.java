package com.yuyu.learnJandS;

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

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			queryStudent(studentDAO);
//			queryStudentByLastName(studentDAO);

//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudentById(2);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(2);
		student.setLastName("Cao");
		studentDAO.updateStudent(student);
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getStudentsByLastName("Zhao");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("create student object");
		Student tmpStudent = new Student("Yuyu", "Zhao", "zyy@test.com");

		studentDAO.save(tmpStudent);

		System.out.println("Saved student. Generated id: " + tmpStudent.getId());

		Student foundStudent = studentDAO.findById(1);
		System.out.println(foundStudent.toString());

	}
}
