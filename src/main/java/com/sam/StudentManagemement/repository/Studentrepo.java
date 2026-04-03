package com.sam.StudentManagemement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.StudentManagemement.entity.Student;
@Repository
public interface Studentrepo extends JpaRepository<Student, Integer> {

}
