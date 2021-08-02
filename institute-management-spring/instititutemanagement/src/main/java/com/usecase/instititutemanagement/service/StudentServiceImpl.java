package com.usecase.instititutemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.usecase.instititutemanagement.model.Student;
import com.usecase.instititutemanagement.repository.StudentRepo;



@Service
@Transactional
public class StudentServiceImpl extends BaseService implements StudentService{

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
    public Optional<Student> fetchbyid(Integer id) {
        return studentRepo.findById(id);
    }

	@Override
	public void updateStudent(Student student) {
		studentRepo.save(student); 
		
	}

	@Override
	public boolean saveStudent(Student student) {
		studentRepo.save(student);
		return true;
	}

	@Override
	public boolean deleteStudent(Integer id) {	
		if(studentRepo.equals("")) {
			System.out.println("There are no Students");
		}
		else 
        studentRepo.deleteById(id);
		return true;
	}

	
    // @Autowired
    // private StudentRepo repo;

    // @Override
    // public List<Student> findByLastname(String lname) {
    //     return repo.findByLastname(lname);
    // }

    // @Override
    // public List<Student> byLastOrFirstname(String lname, String fname) {
    //     return repo.byLNFN(lname, fname);
    // }

    // @Override
    // public Boolean save(Student stu) {
    //     repo.save(stu);

    //     return true;
    // }

    // @Override
    // public List<Student> fetchAll() {
    //     return repo.findAll();
    // }

    // @Override
    // public Optional<Student> fetchById(Integer id) {
    //     return repo.findById(id);
    // }

}