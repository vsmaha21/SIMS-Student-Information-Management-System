package com.college.mis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.college.mis.model.*;



@SpringBootApplication
public class MisApplication {
	
	@Autowired
	private static JdbcTemplate jdbc;
	
	
//	public void setJdbc(JdbcTemplate jdbc) {
//		this.jdbc = jdbc;
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(MisApplication.class, args);
		 List<Student>  list =findAll();
		 System.out.println(list);
	}
	
	public static List<Student> findAll() {
		  
		  String sql="select * from public.\"StudentClass6\""; RowMapper<Student> mapper=(rs,rowNum) ->
		  {
			  Student s=new Student();
			  
			  s.setsId(rs.getInt("sid"));
			  s.setsName(rs.getString("sname"));
			  s.setsAddress(rs.getString("saddress"));
			  s.setsGrade(rs.getDouble("smarks"));
				
		  return s; 
		  
		  }; 
		  
		  return jdbc.query(sql, mapper); 
		  
		  }

}
