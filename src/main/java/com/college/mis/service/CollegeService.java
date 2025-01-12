package com.college.mis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.college.mis.model.Instructor;
import com.college.mis.model.Student;
import com.college.mis.model.Subject;
import com.college.mis.repo.InstructorRepo;
import com.college.mis.repo.StudentRepo;
import com.college.mis.repo.SubjectRepo;

@Service
public class CollegeService {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	SubjectRepo subjectRepo;
	
	@Autowired
	InstructorRepo instructorRepo;
	
	//add/update/delete student
	public Boolean addNewOrUpdateStudent(Student s) {
			return studentRepo.save(s)!=null;		
	}
			
	//delete by Id
	public Boolean deleteStudentById(Integer id) {
		boolean flag = studentRepo.existsById(id);
		studentRepo.deleteById(id);
		return flag;
	}
	
	
	//get students fees pending
	public Map<Student,Integer> findStudentsWithPendingFees(){
		
		Map<Student,Integer> map = new HashMap<>();
		
		studentRepo.findAll()
					.stream()
					.forEach(s->{
						Integer feesPaid = s.getFeesPaid();
						Integer totalFees = s.getSubject().stream().map(sub -> sub.getFees()).reduce(0, (a, b) -> a + b);
						if(!totalFees.equals(feesPaid)) {
							map.put(s, totalFees-feesPaid);
							}
					});;
		return map;
	}
	
	//get ALL students details
	public List<Student> findALLStudentsWithDetails(){
		return studentRepo.findAll();
	}
	
	//get All Instructor Details
	public List<Instructor> findALLInstructorssWithDetails(){
		return instructorRepo.findAll();
	}
	

}
