package com.gco.studentService.service;

import java.util.List;
import com.gco.studentService.entities.Student;
import com.gco.studentService.exception.NoSuchUserException;


public interface StudentService {

	
	public Student registerUser(Student student);
	
	
	public Student viewStudent(int studentId);
	
	public void updateStudent(int studentId,Student student);
	
	public boolean removeStudent(int studentId) throws NoSuchUserException;
	
	public List<Student> findAllStudents();
	
	
}

