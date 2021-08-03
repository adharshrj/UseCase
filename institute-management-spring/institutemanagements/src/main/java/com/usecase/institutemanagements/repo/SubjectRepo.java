package com.usecase.institutemanagements.repo;
import com.usecase.institutemanagements.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,String>{
    
}