package com.usecase.institutemanagements.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/student")
	@PreAuthorize("hasRole('STUDENT') or hasRole('PROF') or hasRole('ADMIN')")
	public String studentAccess() {
		return "Student Dashboard.";
	}

	@GetMapping("/prof")
	@PreAuthorize("hasRole('PROF')")
	public String profAccess() {
		return "Professpr Dashboard.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admininistrator Dashboard.";
	}
}