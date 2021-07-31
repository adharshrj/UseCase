package com.usecase.instititutemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.instititutemanagement.model.Student;
import com.usecase.instititutemanagement.repo.StudentRepo;



@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	//private List<Prof> list = new ArrayList<Prof>();
	
	// Admin admin = new Admin();
	// Prof prof = new Prof();
	
	// String  profSchoolName;
	
	
	@Override
	public List<Student> getAllStudents() {
		// List<Prof> list = new ArrayList<Prof>();
		// for(Prof prof : profRepo.findAll()) {
		// 	list.add(prof);
		// }
		// return list;
		return  studentRepo.findAll();
	}

	@Override
    public Optional<Student> findone(Long studentId) {
        return studentRepo.findById(studentId);
    }

	@Override
	public void saveStudent(Student student) {
		studentRepo.save(student); 
		
	}

	@Override
	public boolean updateStudent(Student student) {
		studentRepo.save(student);
		return true;
	}

	@Override
	public boolean deleteStudent(Student student) {	
		if(studentRepo.equals("")) {
			System.out.println("There are no Professors");
		}
		else 
        studentRepo.delete(student);
		return true;
	}

}