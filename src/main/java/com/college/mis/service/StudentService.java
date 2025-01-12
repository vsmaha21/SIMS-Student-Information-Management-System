package com.college.mis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.college.mis.model.Student;
import com.college.mis.model.Subject;
import com.college.mis.repo.StudentRepo;
import com.college.mis.repo.SubjectRepo;

@Service
public class StudentService {
		
		@Autowired
		StudentRepo studentrRepo;
		
		@Autowired
		SubjectRepo subjectRepo;
	
		//get student name by id
		public Student getStudentByID(Integer id) {
			return studentrRepo.findById(id).orElse(null);
		}
		
		//get all students
		public Map<Integer,String> getAllStudents() {
			Map<Integer,String> map= new HashMap<>();
			studentrRepo.findAll().stream().forEach(s->map.put(s.getRollNo(), s.getName()));
			return map;
		}
		
		//Count All students
		public Long getStudentsCount() {
			return studentrRepo.count();
		}
		
		//get students by subject
		public List<Student> getStudentsBySubject(String subjectName) {
			List<Subject> subject = subjectRepo.findBySubjectName(subjectName.toUpperCase());
			if(subject.size()<1) return null;
			return studentrRepo.findBySubject(subject.get(0));
//			return null;
		}
			
		//get average  marks of all students
		public Double getStudentsAvg() {
			return studentrRepo.findMarksAverage();
		}

				
//		//get Student having highest marks
		public Student getTopper() {
			return studentrRepo.findStudentWithMaxMarks();
		}

}
