package com.sam.StudentManagemement.service;

import java.util.List;

import com.sam.StudentManagemement.entity.Student;

public interface Studentservice {
	
	
	public List<Student> getAllStudents();
	
	

	public Student Savestudent(Student student);
	
	public Student getbyid(int id);
	
	



	public void deletebyid(int id);

}
