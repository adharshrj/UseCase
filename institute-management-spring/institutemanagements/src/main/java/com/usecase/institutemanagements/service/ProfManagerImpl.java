package com.usecase.institutemanagements.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.usecase.institutemanagements.entity.Prof;
import com.usecase.institutemanagements.repo.ProfRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ProfManagerImpl implements ProfManager {

    @Autowired
    private ProfRepo repo;

    @Override
    public List<Prof> findByLastname(String lname) {
        return repo.findByLastname(lname);
    }

    @Override
    public List<Prof> byLastOrFirstname(String lname, String fname) {
        return repo.byLNFN(lname, fname);
    }

    @Override
    public Boolean save(Prof profReq) {
        repo.save(profReq);

        return true;
    }

    @Override
    public List<Prof> fetchAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Prof> fetchById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Boolean delete(Integer id){
        repo.deleteById(id);
        return true;
    }
    
}
