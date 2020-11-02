package com.niit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.model.Student;
//import com.niit.dao.StudentDao;

@Service
public class StudentDaoImpl {
	
	@Autowired
	private StudentDao repository;
	
	public Student saveStudent(Student stu) {
		return repository.save(stu);
	}
	
	public List<Student> saveStudents(List<Student> stus) {
		return repository.saveAll(stus);
	}
	
	public List<Student> getStudents(){
		return repository.findAll();
	}
	
	public Student getStudentById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Student getStudentByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteStudent(int id) {
		repository.deleteById(id);
		
		return "Student Removed Successfully || ID - "+id;
	}
	
	public Student updateStudent(Student stu) {
		Student existingStudent = repository.findById(stu.getId()).orElse(null);
		existingStudent.setName(stu.getName());
		existingStudent.setCourse(stu.getCourse());
		existingStudent.setFee(stu.getFee());
		existingStudent.setMarks(stu.getMarks());
		return repository.save(existingStudent);
	}
}
