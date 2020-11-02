package com.niit.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.model.Student;



public interface StudentDao extends JpaRepository<Student, Integer> {
/////////////////////////////////////////////////////<Model CLass Object, Data Type of ID>
	
	Student findByName(String name);
	
}
