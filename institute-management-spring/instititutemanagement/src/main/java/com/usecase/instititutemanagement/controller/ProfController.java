package com.usecase.instititutemanagement.controller;

import java.util.Collection;
import java.util.Collections.*;
import java.util.*;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.instititutemanagement.error.*;
import com.usecase.instititutemanagement.model.*;
import com.usecase.instititutemanagement.repository.*;
import com.usecase.instititutemanagement.service.*;


@RestController
@RequestMapping("api")	
public class ProfController extends BaseController{

	Logger logger = LoggerFactory.getLogger(ProfController.class);

	@Autowired
	private StudentService sservice;
	
	@GetMapping(value = "/student/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Student>> fetchAllStudents() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Student>>(sservice.getAllStudents(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping(value = "/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Student>> fetchStudent(@PathVariable int id) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Student>>(sservice.fetchbyid(id), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@PostMapping(value = "/student/list/add",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> postStudent(@Valid @RequestBody Student student) throws ErrorCust {
	
		try {	
		sservice.saveStudent(student);
		sservice.getAllStudents().forEach(System.out::println);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	 	catch (ErrorCust ec ) {
		throw ec;
		}
	}

	@PutMapping(value = "/student/list/update",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> putStuds(@Valid @PathVariable int id, @RequestBody Student student) throws ErrorCust {
		try {	
			logger.debug(student.toString());
			sservice.updateStudent(student);
		return new ResponseEntity<String>("Update Successfully!", HttpStatus.OK);
		} catch (ErrorCust ec ) {
		throw ec;
		}
	}

	
}