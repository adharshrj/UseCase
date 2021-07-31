package com.usecase.instititutemanagement.service;
import java.util.List;
import java.util.Optional;
import com.usecase.instititutemanagement.model.Admin;

public interface AdminService {
	
	public List<Admin> getAllAdmins();
	public Optional<Admin> findone(Long adminId);
	public void saveAdmin (final Admin admin);
	public boolean updateAdmin (Admin admin);
	public boolean deleteAdmin (Admin admin);
}