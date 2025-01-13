package com.college.mis.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(ValidationAspect.class);
	
	@Around("execution (* com.college.mis.controller.StudentController.getStudentByID(..)) && args(id) || execution (* com.college.mis.controller.CollegeController.deleteStudentById(..)) && args(id)")
	public Object validateAndUpdate(ProceedingJoinPoint jp,int id) throws Throwable {
	if (id<0) {
		LOGGER.info("StudentId is negative, updating it to positive value");
		
		id=-id;
		LOGGER.info("new Id :"+id);
	}
	
	Object obj=jp.proceed(new Object[] {id});
		
		return obj;
	}
	
	
}
