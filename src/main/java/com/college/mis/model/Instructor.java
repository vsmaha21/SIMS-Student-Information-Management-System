package com.college.mis.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Component
@Scope("prototype")
@Entity
public class Instructor {
	@Id
	private Integer Id;
	
	private String InstructorName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_id")
	private Subject subject;
//	
	private String eMail;


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getInstructorName() {
		return InstructorName;
	}

	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Instructor [Id=" + Id + ", InstructorName=" + InstructorName + ", subject=" + subject + ", eMail="
				+ eMail + "]";
	}
	
	
}
