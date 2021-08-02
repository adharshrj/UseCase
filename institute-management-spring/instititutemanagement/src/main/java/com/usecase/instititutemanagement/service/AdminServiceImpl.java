package com.usecase.instititutemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.usecase.instititutemanagement.model.*;
import com.usecase.instititutemanagement.repository.*;


@Service
@Transactional
public class AdminServiceImpl extends BaseService implements AdminService {

	@Autowired
	@Qualifier("adminRepo")
	private AdminRepo adminRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	//private List<Admin> list = new ArrayList<Admin>();
	
	
	@Override
	public List<Admin> getAllAdmins() {
		// List<Admin> list = new ArrayList<Admin>();
		// for (Admin admin : adminRepo.findAll()) {
		// 	list.add(admin);
		// }
		// return list;
		return adminRepo.findAll();
	}

	@Override
    public Optional<Admin> fetchbyid(Integer id) {
        return adminRepo.findById(id);
    }

	@Override
	public boolean saveAdmin(Admin admin) {
		adminRepo.save(admin);
		return true;
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminRepo.save(admin);
		
	}

	@Override
	public boolean deleteAdmin(int id) {
		if(adminRepo.equals("")) {
			System.out.println("There are no admins");
		}
		else 
			adminRepo.deleteById(id);
		return true;
	}
}