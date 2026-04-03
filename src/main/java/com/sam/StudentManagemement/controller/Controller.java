package com.sam.StudentManagemement.controller;

import java.util.List;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sam.StudentManagemement.entity.Student;
import com.sam.StudentManagemement.service.Studentservice;

import jakarta.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private Studentservice service;

	@GetMapping("/h")
	public String home() {
		return "index"; // viewbpage html file ->home.html
	}

	@GetMapping("/stud")
	public String getAllString(Model model) {
		model.addAttribute("stud", service.getAllStudents());
		return "studpage";

	}
	@GetMapping("/add")
	public String cretestudent(Model model) {
		Student student = new Student();
		model.addAttribute("studkey", student);
		return "addstud";

	}
	@PostMapping("/studentshtmladdstud")
	public String Savestudent(@ModelAttribute("studkey") Student student) {
		service.Savestudent(student);
		return "redirect:/stud";
		
	}
	
	@GetMapping("/students/edit/{id}")
   public String editstudentform(@PathVariable int id,Model model) {
		model.addAttribute("stud1",service.getbyid(id));
		return "edit";
	}
	@PostMapping("/students/{id}")
	public String updatesave(@PathVariable int id, @ModelAttribute("stud1") Student student) {
		Student extingstud=service.getbyid(id);
		extingstud.setFirstname(student.getFirstname());
		 extingstud.setLastname(student.getLastname());   // ✅ FIX
		    extingstud.setEmail(student.getEmail());  
		service.Savestudent(extingstud);
		return "redirect:/stud";
	}
	@GetMapping("/stud/{id}")
	public String delete(@PathVariable int id) {
		service.deletebyid (id);
		return "redirect:/stud";
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/students/excel")
	public void exportToExcel(HttpServletResponse response) throws Exception {

	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment; filename=students.xlsx");

	    List<Student> list = service.getAllStudents();

	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Students");

	    // Header row
	    Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("ID");
	    header.createCell(1).setCellValue("First Name");
	    header.createCell(2).setCellValue("Last Name");
	    header.createCell(3).setCellValue("Email");

	    // Data rows
	    int rowNum = 1;
	    for (Student s : list) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(s.getId());
	        row.createCell(1).setCellValue(s.getFirstname());
	        row.createCell(2).setCellValue(s.getLastname());
	        row.createCell(3).setCellValue(s.getEmail());
	    }

	    workbook.write(response.getOutputStream());
	    workbook.close();
	}
	
	
	
}