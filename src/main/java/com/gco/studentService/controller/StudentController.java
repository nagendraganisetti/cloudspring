package com.gco.studentService.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gco.studentService.service.*;

import com.gco.studentService.entities.*;
import com.gco.studentService.exception.NoSuchUserException;
import com.gco.studentService.service.*;





@RestController
@RequestMapping("/StudentController")
public class StudentController {
	
	Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	
	//Add User
	@PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Student> registerUser(@RequestBody Student student) {
		
		log.info("postStudent method of StudentController called ");
		Student newStudent = studentService.registerUser(student);
		if(student != null) {
			return new ResponseEntity<Student>(newStudent, HttpStatus.ACCEPTED);
		}
		 
		log.info("postStudent method of StudentController ends ");
		return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//view student by id
		@GetMapping(path="/findStudentById/{studentId}")
		
		public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId) throws NoSuchUserException{
			
			log.info("get Student method of Student Controller to get student by Id is called");
			
			ResponseEntity<Student> response= null;
			Student result = studentService.viewStudent(studentId);
			if(result != null)
				response = new ResponseEntity<Student>(result,HttpStatus.FOUND);
			else
				response = new ResponseEntity<Student>(result,HttpStatus.BAD_REQUEST);
			
			log.info("get Student method of Student Controller to get student by Id ends");
			return response;
		}
		
		//delete student by id
		@DeleteMapping(path="/deleteStudentById/{studentId}")
		
		public ResponseEntity<Boolean> deleteStudentById(@PathVariable("studentId")int studentId) throws NoSuchUserException{
			
			log.info("deleteStudent method of Student Controller called");
			ResponseEntity<Boolean> response=null;
			boolean result = studentService.removeStudent(studentId);
			if(result)
				response = new ResponseEntity<Boolean>(result,HttpStatus.OK);
			else
				response = new ResponseEntity<Boolean>(result,HttpStatus.BAD_REQUEST);
			
			log.info("deleteStudent method of Student Controller ends");
			return response;
		}
		
		  
		//view all students
		@GetMapping("/viewAllStudents")
		  public ResponseEntity<?> findAllStudents(){
		        List<Student> findAll = studentService.findAllStudents();
		        return new ResponseEntity<List<Student>>(findAll,HttpStatus.OK);
		    }
		   
		//update student
				@PutMapping(path="/updateStudent" ,consumes = "application/json", produces = "application/json")
				
				public ResponseEntity<Student> updateStudent(@RequestBody Student student){
					
					log.info("putStudent method of Student Controller called");
					
					ResponseEntity<Student> response = null;
					studentService.updateStudent(student.getStudentId(),student);
					
					log.info("putStudent method of Student Controller ends");
					return new ResponseEntity<>(student, HttpStatus.OK);
					
				}
		

}

