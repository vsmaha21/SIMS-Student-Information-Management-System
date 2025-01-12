package com.college.mis.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Component
//@Scope("prototype")
@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String subjectId;
	
	private String subjectName;
	
	private Integer fees;

	
	
	public Subject(String subjectId, String subjectName, Integer fees) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.fees = fees;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Subject() {
		super();
	}
	
	

	
	
	
	
}
