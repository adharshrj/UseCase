package com.usecase.instititutemanagement.service;
import java.util.List;
import java.util.Optional;
import com.usecase.instititutemanagement.model.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Optional<Student> fetchbyid(Integer id);
	public void saveStudent (Student student);
	public boolean updateStudent (Student student);
	public boolean deleteStudent (Integer id);

	// public List<Student> findByLastname(String lname);
    // public Boolean save(Student stu);
    // public List<Student> byLastOrFirstname(String lname,String fname);
    // public List<Student> fetchAll();
    // public Optional<Student> fetchById(Integer id);
}