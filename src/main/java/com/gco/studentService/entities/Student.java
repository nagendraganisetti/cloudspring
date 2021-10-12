package com.gco.studentService.entities;

import javax.persistence.Column;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Data
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
@Component 
@Entity /* Creating table*/
@Table(name = "Student") /* Specifying table name*/
public class Student {

	@Id /* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* generating value automatically*/
    @Column(name="student_id")
	private int studentId;
	
	
	
	/* specifying column name, giving length and giving
    constraint as not null*/
	
	
	@Column(name="student_password", length=25,nullable=true)
	private String studentPassword;
	
	@Column(name="student_first_name", length=25,nullable=true)
	private String studentFirstName;
	
	@Column(name="student_last_name", length=25,nullable=true)
	private String studentLastName;
	
	@Column(name="student_contact_no", length=10,nullable=true)
	private String studentContactNo;
	
	@Column(name="student_emailId", length=50,nullable=true)
	private String studentEmailId;
	
	public Student() {
		
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentContactNo() {
		return studentContactNo;
	}

	public void setStudentContactNo(String studentContactNo) {
		this.studentContactNo = studentContactNo;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public Student get() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

