package com.sam.StudentManagemement.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.StudentManagemement.entity.Student;
import com.sam.StudentManagemement.repository.Studentrepo;
import com.sam.StudentManagemement.service.Studentservice;

@Service
public class serviceimp implements Studentservice{
    @Autowired
	Studentrepo studentrepo;

	@Override
	public List<Student> getAllStudents() {
		List<Student> list= studentrepo.findAll();
		return list;
	}

	@Override
	public Student Savestudent(Student student) {
		return studentrepo.save(student);
		
	}

	
	@Override
	public Student getbyid(int id) {
		
		return studentrepo.findById(id).get();
	}

	@Override
	public void deletebyid(int id) {
		studentrepo.deleteById(id);
		
	}

	
	
	
	
    
	
    

}
