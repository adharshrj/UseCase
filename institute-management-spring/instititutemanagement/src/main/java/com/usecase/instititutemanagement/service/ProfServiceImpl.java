package com.usecase.instititutemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.usecase.instititutemanagement.model.Prof;
import com.usecase.instititutemanagement.repository.ProfRepo;



@Service
@Transactional
public class ProfServiceImpl extends BaseService implements ProfService{

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
    public Optional<Prof> fetchbyid(Integer id) {
        return profRepo.findById(id);
    }

	@Override
	public boolean saveProf(Prof prof) {
		profRepo.save(prof);
		return true;
		
	}

	@Override
	public void updateProf(Prof prof) {
		profRepo.save(prof);
	}

	@Override
	public boolean deleteProf(int id) {	
		if(profRepo.equals("")) {
			System.out.println("There are no Professors");
		}
		else 
        profRepo.deleteById(id);
		return true;
	}

}