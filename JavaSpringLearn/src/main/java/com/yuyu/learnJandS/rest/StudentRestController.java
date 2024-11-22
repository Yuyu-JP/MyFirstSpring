package com.yuyu.learnJandS.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuyu.learnJandS.dao.StudentDAO;
import com.yuyu.learnJandS.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private StudentDAO studentDAO;
	
	public StudentRestController(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	//define endpoint for "/students" to get student list
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> students = studentDAO.getAllStudents();
		
		return students;
	}
		
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		Student student = studentDAO.findById(studentId);
		
		if (student == null) {
			throw new StudentNotFoundException("The student with ID '" + studentId + "' is not found.");
		}
		
		return student;
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
}
