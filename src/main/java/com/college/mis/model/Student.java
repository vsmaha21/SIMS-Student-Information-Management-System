package com.college.mis.model;

import java.util.List;

public class Student {
	
	Integer sId;
	String sName;
	String sAddress;
	Double sGrade;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public Double getsGrade() {
		return sGrade;
	}
	public void setsGrade(Double sGrade) {
		this.sGrade = sGrade;
	}
	
//	List<Subject> subjects;
//	Integer feesPaid;
	
	
}
