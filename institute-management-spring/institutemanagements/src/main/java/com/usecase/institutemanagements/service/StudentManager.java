package com.usecase.institutemanagements.service;

import java.util.List;
import java.util.Optional;

import com.usecase.institutemanagements.entity.Student;

public interface StudentManager {
    public List<Student> findByLastname(String lname);

    public Boolean save(Student stuReq);

    public Boolean delete(Integer id);

    public List<Student> byLastOrFirstname(String lname,String fname);

    public List<Student> fetchAll();

    public Optional<Student> fetchById(Integer id);

}