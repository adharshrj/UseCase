package com.usecase.institutemanagements.repo;

import java.util.List;

import com.usecase.institutemanagements.entity.Prof;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepo extends JpaRepository<Prof,Integer> {
    public List<Prof> findByLastname(String lname);

    public List<Prof> findByLastnameOrFirstname(String lname,String fname);

    //jpql
    @Query("select s from Prof s where s.firstname=:fname or s.lastname=:lname")
    public List<Prof> byLNFN(String lname,String fname);

    @Query(value="select * from tbl_prof where lname like '%:filter%'",nativeQuery=true)
    public List<Prof[]> fetchBylName(String filter);

    
}
