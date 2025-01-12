package com.college.mis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.mis.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Integer>{

	List<Subject> findBySubjectName(String subject);

}
