package com.college.mis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.mis.model.Student;
import com.college.mis.repo.StudentRepo;
import com.college.mis.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//get student name by id
	@GetMapping("/get/{id}")
	public Student getStudentByID(@PathVariable Integer id) {
		return studentService.getStudentByID(id);
	}
	
	//get all students
	@GetMapping("/get/all")
	public Map<Integer,String> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	//get students by subject
	@GetMapping("/getBy/{subject}")
	public List<Student> getStudentsBySubject(@PathVariable String subject) {
		return studentService.getStudentsBySubject(subject);
	}
	
	//Count All students
	@GetMapping("/count")
	public Long getStudentsCount() {
		return studentService.getStudentsCount();
	}
	
	//get average  marks of all students
	@GetMapping("/avg")
	public Double getStudentsAvg() {
		return studentService.getStudentsAvg();
	}
	
	//get Student having highest marks
	@GetMapping("/topper")
	public Student getTopper() {
		return studentService.getTopper();
	}

}
