package com.usecase.institutemanagements.repo;


import java.util.List;

import com.usecase.institutemanagements.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    public List<Student> findByLastname(String lname);

    public List<Student> findByLastnameOrFirstname(String lname,String fname);

    //jpql
    @Query("select s from Student s where s.firstname=:fname or s.lastname=:lname")
    public List<Student> byLNFN(String lname,String fname);

    @Query(value="select * from tbl_student where lname like '%:filter%'",nativeQuery=true)
    public List<Object[]> fetchBylName(String filter);

    
}
