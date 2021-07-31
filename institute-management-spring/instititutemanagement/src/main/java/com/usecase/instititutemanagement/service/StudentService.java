package com.usecase.instititutemanagement.service;
import java.util.List;
import java.util.Optional;
import com.usecase.instititutemanagement.model.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Optional<Student> findone(Long studentId);
	public void saveStudent (final Student student);
	public boolean updateStudent (Student student);
	public boolean deleteStudent (Student student);
}