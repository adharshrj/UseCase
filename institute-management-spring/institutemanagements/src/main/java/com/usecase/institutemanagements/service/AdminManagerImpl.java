package com.usecase.institutemanagements.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.usecase.institutemanagements.entity.Admin;
import com.usecase.institutemanagements.repo.AdminRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class AdminManagerImpl implements AdminManager {

    @Autowired
    private AdminRepo repo;

    @Override
    public List<Admin> findByLastname(String lname) {
        return repo.findByLastname(lname);
    }

    @Override
    public List<Admin> byLastOrFirstname(String lname, String fname) {
        return repo.byLNFN(lname, fname);
    }

    @Override
    public Boolean save(Admin adminReq ) {
        repo.save(adminReq);

        return true;
    }

    @Override
    public List<Admin> fetchAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Admin> fetchById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Boolean delete(Integer id){
        repo.deleteById(id);
        return true;
    }
    
}
