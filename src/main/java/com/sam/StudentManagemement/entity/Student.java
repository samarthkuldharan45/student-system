package com.sam.StudentManagemement.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
	 
	 @Column(name="first_Name")
	 private String firstname;
	 
	 @Column(name="last_Name")
	 private String lastname;
	 
	 private String email;

	 public Student(int id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	 }

	 public Student() {
		super();
		// TODO Auto-generated constructor stub
	 }

	 public int getId() {
		 return id;
	 }

	 public void setId(int id) {
		 this.id = id;
	 }

	 public String getFirstname() {
		 return firstname;
	 }

	 public void setFirstname(String firstname) {
		 this.firstname = firstname;
	 }

	 public String getLastname() {
		 return lastname;
	 }

	 public void setLastname(String lastname) {
		 this.lastname = lastname;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }
	 
	 
}
