package com.college.mis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.college.mis.model.*;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

	List<Student> findBySubject(Subject subject);
	
	@Query("select avg(s.marks) from Student s")
	Double findMarksAverage();
	
	
	@Query("SELECT s FROM Student s WHERE s.marks = (SELECT MAX(s1.marks) FROM Student s1)")
    Student findStudentWithMaxMarks();
	

}
