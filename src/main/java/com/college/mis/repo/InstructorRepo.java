package com.college.mis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.mis.model.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer>{

}
