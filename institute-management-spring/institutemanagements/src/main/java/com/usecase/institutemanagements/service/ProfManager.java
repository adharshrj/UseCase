package com.usecase.institutemanagements.service;
import java.util.List;
import java.util.Optional;

import com.usecase.institutemanagements.entity.Prof;

public interface ProfManager {
    public List<Prof> findByLastname(String lname);

    public Boolean save(Prof profReq);

    public Boolean delete(Integer id);

    public List<Prof> byLastOrFirstname(String lname,String fname);

    public List<Prof> fetchAll();

    public Optional<Prof> fetchById(Integer id);
}