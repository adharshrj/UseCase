package com.usecase.instititutemanagement.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.instititutemanagement.error.ErrorCust;
import com.usecase.instititutemanagement.model.Admin;
import com.usecase.instititutemanagement.model.Prof;
import com.usecase.instititutemanagement.model.Student;
import com.usecase.instititutemanagement.repository.AdminRepo;
import com.usecase.instititutemanagement.repository.ProfRepo;
import com.usecase.instititutemanagement.repository.StudentRepo;
import com.usecase.instititutemanagement.service.AdminService;
import com.usecase.instititutemanagement.service.ProfService;
import com.usecase.instititutemanagement.service.StudentService;
@RestController
@RequestMapping("api")	
public class AdminController extends BaseController{
	Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
	private AdminRepo adminRepo;
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private ProfRepo profRepo;
	
	@Autowired
    private AdminService aservice;
	@Autowired
	private ProfService pservice;
	@Autowired
	private StudentService sservice;


    @GetMapping(value = "/admin/list/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Admin>> fetchAllAdmins() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Admin>>(aservice.getAllAdmins(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}
		
	
    @GetMapping(value = "/student/list/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Student>> fetchAllStudents() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Student>>(sservice.getAllStudents(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping(value = "/prof/list/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Prof>> fetchAllProfs() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Prof>>(pservice.getAllProfs(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@PostMapping(value = "/prof/list/add",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prof> postProf(@Valid @RequestBody Prof prof) throws ErrorCust {
	
		try {	
		pservice.saveProf(prof);
		pservice.getAllProfs().forEach(System.out::println);
		return new ResponseEntity<Prof>(prof, HttpStatus.OK);
	}
	 	catch (ErrorCust ec ) {
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

    @PutMapping(value = "/prof/list/update",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> putProfs(@Valid @PathVariable int id, @RequestBody Prof prof) throws ErrorCust {
		try {	
		logger.debug(prof.toString());
		pservice.updateProf(prof);
		return new ResponseEntity<String>("Update Successfully!", HttpStatus.OK);
		} catch (ErrorCust ec ) {
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


	@GetMapping(value = "/admin/list/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Admin>> fetchAdmin(@PathVariable int id) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Admin>>(aservice.fetchbyid(id), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping(value = "/prof/list/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Prof>> fetchProf(@PathVariable int id) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Prof>>(pservice.fetchbyid(id), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping(value = "/student/list/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Student>> fetchStudent(@PathVariable int id) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Student>>(sservice.fetchbyid(id), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}
	
	@DeleteMapping(value ="/prof/list/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProfs(@PathVariable int id, @RequestBody Prof prof) throws ErrorCust {
    try {
        pservice.deleteProf(id);
    }catch(ErrorCust ec){
    	throw ec;
	    }
    }

	@DeleteMapping(value = "/student/list/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudents(@Valid @PathVariable int id, @RequestBody Student student) throws ErrorCust {
    try {
        sservice.deleteStudent(id);
    }catch(ErrorCust ec){
    	throw ec;
	    }
    }
	
}