package com.usecase.institutemanagements.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.usecase.institutemanagements.entity.Student;
import com.usecase.institutemanagements.repo.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class StudentManagerImpl implements StudentManager {

    @Autowired
    private StudentRepo repo;

    @Override
    public List<Student> findByLastname(String lname) {
        return repo.findByLastname(lname);
    }

    @Override
    public List<Student> byLastOrFirstname(String lname, String fname) {
        return repo.byLNFN(lname, fname);
    }

    @Override
    public Boolean save(Student stuReq) {
        repo.save(stuReq);

        return true;
    }

    @Override
    public Boolean delete(Integer id){
        repo.deleteById(id);
        return true;
        
    }

    @Override
    public List<Student> fetchAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> fetchById(Integer id) {
        return repo.findById(id);
    }
    
}
