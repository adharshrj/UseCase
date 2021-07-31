package com.usecase.instititutemanagement.repo;
import java.util.Optional;
import com.usecase.instititutemanagement.controller.StudentController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.instititutemanagement.model.Student;
@Repository("studentrepo")
public interface StudentRepo extends JpaRepository<Student, Long> {
	
}