package com.college.mis;

import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.college.mis.model.*;
import com.college.mis.repo.InstructorRepo;
import com.college.mis.repo.StudentRepo;


@SpringBootApplication
public class MisApplication {
	
	
	public static void main(String[] args)  {
		ApplicationContext context=	SpringApplication.run(MisApplication.class, args);
		
		 StudentRepo repo=context.getBean(StudentRepo.class);
		
//		 Student s = context.getBean(Student.class);
//		 s.setRollNo(1);
//		 s.setMarks(90);
//		 s.setName("Venkatesh");
//		 s.setAddress("Ausa, Latur");
//		 s.setFeesPaid(17500);	
//		 s.setSubject(List.of(new Subject("A101","MARATHI",1000),new Subject("A103","ENGLISH",1500),new Subject("A104","PHYSICS",5000),new Subject("A105","CHEMISTRY",5000),new Subject("A107","MATHEMATICS",5000)));
//		 System.out.println(s);
//		 repo.save(s);
//		 	 
		  
		 
		 InstructorRepo repo2=context.getBean(InstructorRepo.class);
			
		 Instructor t = context.getBean(Instructor.class);
		 t.setId(1);
		 t.setInstructorName("NR Bhosale");
		 t.seteMail("nrbhosale@gmail.com");
		 t.setSubject(new Subject("A101","MARATHI",1000));
		 System.out.println(t);
		 repo2.save(t);
		 
		 System.out.println(repo2.findAll());
			 
		 
//		 repo2.delete(t);
//		 repo.delete(s);
		 List<Student>  list =repo.findAll();
		 System.out.println(list);
	}
	

}
