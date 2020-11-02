package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.Student;
import com.niit.dao.StudentDaoImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class StudentController {
	
	@Autowired
	private StudentDaoImpl sdao;
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST})
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student stu) {
		return sdao.saveStudent(stu);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST})
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> stus) {
		return sdao.saveStudents(stus);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return sdao.getStudents();
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
	@GetMapping("/studentById/{id}")
	public Student findStudentById(@PathVariable int id) {
		return sdao.getStudentById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
	@GetMapping("/studentByName/{name}")
	public Student findStudentByName(@PathVariable String name) {
		return sdao.getStudentByName(name);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.PUT})
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student stu) {
		return sdao.updateStudent(stu);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.DELETE})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
		 sdao.deleteStudent(id);
		 return new ResponseEntity<>(HttpStatus.OK); 
	}
}
