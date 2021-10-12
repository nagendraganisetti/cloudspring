package com.gco.studentService.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.gco.studentService.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	

	@Query( value = "SELECT u FROM Student u WHERE u.studentId =?1")
	Student findStudentById(String studentId);

}

