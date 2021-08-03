package com.usecase.institutemanagements.repo;


import java.util.List;
import com.usecase.institutemanagements.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    public List<Admin> findByLastname(String lname);

    public List<Admin> findByLastnameOrFirstname(String lname,String fname);

    //jpql
    @Query("select s from Admin s where s.firstname=:fname or s.lastname=:lname")
    public List<Admin> byLNFN(String lname,String fname);

    @Query(value="select * from tbl_admin where lname like '%:filter%'",nativeQuery=true)
    public List<Object[]> fetchBylName(String filter);
}
