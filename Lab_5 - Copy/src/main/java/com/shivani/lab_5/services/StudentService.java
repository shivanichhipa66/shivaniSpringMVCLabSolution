package com.shivani.lab_5.services;

import com.shivani.lab_5.entity.Student;

import java.util.List;

public interface StudentService {

	public  Student findbyId(int theId);
		
	public void deleteById(int theId);
		
public void save(Student thestudent);
	
	public  List<Student> findAll();
		

	



}
