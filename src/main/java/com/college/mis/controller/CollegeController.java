package com.college.mis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.mis.model.Instructor;
import com.college.mis.model.Student;
import com.college.mis.service.CollegeService;

@RestController
@RequestMapping("/admin")

public class CollegeController {

	@Autowired
	CollegeService collegeService;

	// add/update/delete student
	@PostMapping("/add/student")
	public Boolean addNewStudent(@RequestBody Student s) {
		return collegeService.addNewOrUpdateStudent(s);

	}

	@PutMapping("/update/student")
	public Boolean updateStudent(@RequestBody Student s) {
		return collegeService.addNewOrUpdateStudent(s);

	}

	@DeleteMapping("/delete/student")
	public Boolean deleteStudent(@RequestBody Student s) {
		return collegeService.deleteStudentById(s.getRollNo());

	}

	// delete by Id
	@DeleteMapping("/delete/student/{id}")
	public Boolean deleteStudentById(@PathVariable Integer id) {
		return collegeService.deleteStudentById(id);
	}

	// get students fees pending
	@GetMapping("/students/fees-pending")
	public Map<Student, Integer> getStudentsWithPendingFees() {
		return collegeService.findStudentsWithPendingFees();
	}

	// get ALL students details
	@GetMapping("/students/all")
	public List<Student> getALLStudentsWithDetails() {
		return collegeService.findALLStudentsWithDetails();
	}

	// get All Instructor Details
	@GetMapping("/instructors")
	public List<Instructor> getALLInstructorssWithDetails() {
		return collegeService.findALLInstructorssWithDetails();
	}

}
