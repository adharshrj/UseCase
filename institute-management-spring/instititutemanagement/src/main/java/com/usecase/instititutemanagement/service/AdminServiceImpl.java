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
public class AdminServiceImpl implements AdminService {

	@Autowired
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
    public Optional<Admin> findone(Long adminId) {
        return adminRepo.findById(adminId);
    }

	@Override
	public void saveAdmin(Admin admin) {
		adminRepo.save(admin);
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		adminRepo.save(admin);
		return true;
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		if(adminRepo.equals("")) {
			System.out.println("There are no admins");
		}
		else 
			adminRepo.delete(admin);
		return true;
	}
}