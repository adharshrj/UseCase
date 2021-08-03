package com.usecase.institutemanagements.service;
import java.util.List;
import java.util.Optional;

import com.usecase.institutemanagements.entity.Admin;

public interface AdminManager {
    public List<Admin> findByLastname(String lname);

    public Boolean save(Admin adminReq);

    public Boolean delete(Integer id);

    public List<Admin> byLastOrFirstname(String lname,String fname);

    public List<Admin> fetchAll();

    public Optional<Admin> fetchById(Integer id);
}