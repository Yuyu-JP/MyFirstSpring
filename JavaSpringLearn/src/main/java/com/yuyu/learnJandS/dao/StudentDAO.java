package com.yuyu.learnJandS.dao;

import java.util.List;

import com.yuyu.learnJandS.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	Student findById(Integer id);
	List<Student> getAllStudents();
	List<Student> getStudentsByLastName(String lastName);
	void updateStudent(Student student);
	void deleteStudentById(Integer id);
	int deleteAll();
}
