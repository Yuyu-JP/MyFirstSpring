package com.yuyu.learnJandS.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yuyu.learnJandS.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> getStudentsByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
		query.setParameter("theData", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void deleteStudentById(Integer id) {
		Student student = findById(id);
		if (student == null) {
			return;
		}
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
		return numRowsDeleted;
	}
	
}
