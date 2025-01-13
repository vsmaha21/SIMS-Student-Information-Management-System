package com.college.mis.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
	public static final Logger LOGGER=LoggerFactory.getLogger(PerformanceAspect.class);
	
	@Around("execution (* com.college.mis.controller.StudentController.*(..)) || execution (* com.college.mis.controller.CollegeController.*(..)) ")
	public Object monitorPerformanceTime(ProceedingJoinPoint jp) throws Throwable {
		
		long startTime=System.currentTimeMillis();
		
		Object obj= jp.proceed();
		long endTime=System.currentTimeMillis();
		
		LOGGER.info("Time taken by request: "+jp.getSignature().getName()+" "+(endTime-startTime)+" ms");
		return obj;
	}
}
