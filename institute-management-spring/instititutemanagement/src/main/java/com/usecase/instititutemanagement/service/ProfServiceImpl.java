package com.usecase.instititutemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.instititutemanagement.model.Prof;
import com.usecase.instititutemanagement.model.Admin;
import com.usecase.instititutemanagement.repo.AdminRepo;
import com.usecase.instititutemanagement.repo.ProfRepo;


@Service
public class ProfServiceImpl implements ProfService{

	@Autowired
	private ProfRepo profRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(ProfServiceImpl.class);

	//private List<Prof> list = new ArrayList<Prof>();
	
	// Admin admin = new Admin();
	// Prof prof = new Prof();
	
	// String  profSchoolName;
	
	
	@Override
	public List<Prof> getAllProfs() {
		// List<Prof> list = new ArrayList<Prof>();
		// for(Prof prof : profRepo.findAll()) {
		// 	list.add(prof);
		// }
		// return list;
		return  profRepo.findAll();
	}

	@Override
    public Optional<Prof> findone(Long profId) {
        return profRepo.findById(profId);
    }

	@Override
	public void saveProf(Prof prof) {
		profRepo.save(prof); 
		
	}

	@Override
	public boolean updateProf(Prof prof) {
		profRepo.save(prof);
		return true;
	}

	@Override
	public boolean deleteProf(Prof prof) {	
		if(profRepo.equals("")) {
			System.out.println("There are no Professors");
		}
		else 
        profRepo.delete(prof);
		return true;
	}

}