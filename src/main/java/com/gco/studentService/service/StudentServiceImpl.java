package com.gco.studentService.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gco.studentService.entities.Student;
import com.gco.studentService.exception.NoSuchUserException;
import com.gco.studentService.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate template;
	
	//add student
	@Override
	public Student registerUser(Student student) {
		// TODO Auto-generated method stub
		log.debug("registerUser service in student service is invoked");
		
//		if(!studentValidation.validateUserFields(student))
//			throw new  StudentAlreadyExistException("User Already Exists");
		return studentRepository.save(student);
	}
	
	//view student details(admin)
	@Override
	public Student viewStudent(int studentId) 
	{
		log.debug("viewStudent service in admin service is invoked");
	Student student = studentRepository.findById(studentId).get();
		
		return student;
	}
	
	//update student
	@Override
	public void updateStudent(int studentId,Student student){
    	log.debug("modifyTraining service in admin service is invoked");
   
		Student s = studentRepository.findById(studentId).get();
		s=student;
		studentRepository.save(s);
		}

	//delete student
	 @Override
		public boolean removeStudent(int studentId) throws NoSuchUserException {
	    	
	    	log.debug("removeTraining service in admin service is invoked");
			try {
				Student student = studentRepository.findById(studentId).get();
				if (student != null) {
					studentRepository.delete(student);
					return true;
				}
			}catch( NoSuchElementException e) {
				throw new NoSuchUserException("Student with "+studentId+" Not found!!");
			}
			return false;
		}

	 //view all students
	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		List<Student> student1 = studentRepository.findAll();
		return student1;
	
	}

   

}
