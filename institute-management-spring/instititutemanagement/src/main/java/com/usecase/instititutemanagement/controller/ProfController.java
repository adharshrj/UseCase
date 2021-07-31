package com.usecase.instititutemanagement.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.usecase.instititutemanagement.error.*;
import com.usecase.instititutemanagement.model.*;
import com.usecase.instititutemanagement.repo.*;
import com.usecase.instititutemanagement.service.*;


@RestController
@RequestMapping("api")	
public class ProfController extends BaseController{
	@Autowired
	private StudentService sservice;
	
	@GetMapping("/student/all")
	public ResponseEntity<Collection<Student>> fetchAllStudents() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Student>>(sservice.getAllStudents(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Optional<Student>> fetchStudent(@PathVariable Long studentId) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Student>>(sservice.findone(studentId), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@PostMapping("/student/list/add")
	public ResponseEntity<Prof> postStudent(@Valid @RequestBody Student student) throws ErrorCust {
	
		try {	
		student.saveStudent(student);
		student.getAllStudents().forEach(System.out::println);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	 	catch (ErrorCust ec ) {
		throw ec;
		}
	}
	
}