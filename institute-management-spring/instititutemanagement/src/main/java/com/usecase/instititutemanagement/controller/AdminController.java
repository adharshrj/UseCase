package com.usecase.instititutemanagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Collections.*;
import java.util.*;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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

import com.usecase.instititutemanagement.model.Admin;
import com.usecase.instititutemanagement.model.Prof;
import com.usecase.instititutemanagement.model.Student;
import com.usecase.instititutemanagement.repo.AdminRepo;
import com.usecase.instititutemanagement.repo.ProfRepo;
import com.usecase.instititutemanagement.repo.StudentRepo;
import com.usecase.instititutemanagement.error.*;
import com.usecase.instititutemanagement.service.*;
@RestController
@RequestMapping("api")	
public class AdminController extends BaseController{
	Logger logger = LoggerFactory.getLogger(AdminController.class);
    private AdminRepo adminRepo;
    private StudentRepo studentRepo;
    private ProfRepo profRepo;

	@Autowired
    private AdminService aservice;
	@Autowired
	private ProfService pservice;
	@Autowired
	private StudentService sservice;

	public AdminController(AdminRepo adminRepo) {
		this.adminRepo = adminRepo;
	}

    @GetMapping("/admin/list/all")
	public ResponseEntity<Collection<Admin>> fetchAllAdmins() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Admin>>(aservice.getAllAdmins(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}
		
	
    @GetMapping("/student/list/all")
	public ResponseEntity<Collection<Student>> fetchAllStudents() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Student>>(sservice.getAllStudents(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping("/prof/list/all")
	public ResponseEntity<Collection<Prof>> fetchAllProfs() throws ErrorCust {
		try{	
			return new ResponseEntity<Collection<Prof>>(pservice.getAllProfs(), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@PostMapping("/prof/list/add")
	public ResponseEntity<Prof> postProf(@Valid @RequestBody Prof prof) throws ErrorCust {
	
		try {	
		prof.saveProf(prof);
		prof.getAllProfs().forEach(System.out::println);
		return new ResponseEntity<Prof>(prof, HttpStatus.OK);
	}
	 	catch (ErrorCust ec ) {
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

    @PutMapping("/admin")
	void update(@Valid @RequestBody Long adminId, String adminName, String adminPhone) {
		Admin admin = adminRepo.findById(adminId);
		admin.setAdminName(adminName);
		admin.setAdminPhone(adminPhone);
		adminRepo.save(admin);
	}

	@GetMapping("/admin/list/{id}")
	public ResponseEntity<Optional<Admin>> fetchAdmin(@PathVariable Long adminId) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Admin>>(aservice.findone(adminId), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping("/prof/list/{id}")
	public ResponseEntity<Optional<Prof>> fetchProf(@PathVariable Long profId) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Prof>>(pservice.findone(profId), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}

	@GetMapping("/student/list/{id}")
	public ResponseEntity<Optional<Student>> fetchStudent(@PathVariable Long studentId) throws ErrorCust {
		try{
			return new ResponseEntity<Optional<Student>>(sservice.findone(studentId), HttpStatus.OK);
		}catch(ErrorCust ec){
			throw ec;
		}
	}
	
	@DeleteMapping("/prof/list/{id}")
    public void deleteProfs(@PathVariable int id) throws ErrorCust {
    try {
        customers.delete(id);
    }catch(ErrorCust nfe){
    	throw nfe;
		//throws new NotFoundException();
	    }
    }

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Long adminId) { 
		Admin admin = adminRepo.findById(adminId);
		adminRepo.delete(admin);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/prof/{id}")
	public ResponseEntity<?> deleteProf(@PathVariable Long profId) { 
		Prof prof = profRepo.findById(profId);
		profRepo.delete(prof);
		return ResponseEntity.ok().build();
	}
}