package com.college.mis.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

@Component
@Scope("prototype")
@Entity
public class Student {

	//properties 
	@Id
	private int rollNo;
	private String name;
	private int marks;
	
	private String address;
	
	private Integer feesPaid;
	
	//@Id
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_subject", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name ="subject_id") )
	private List<Subject> subject= new ArrayList<>();
	
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	//getters and setters
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getFeesPaid() {
		return feesPaid;
	}
	public void setFeesPaid(Integer feesPaid) {
		this.feesPaid = feesPaid;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name +  "]";
	}
	
	
}