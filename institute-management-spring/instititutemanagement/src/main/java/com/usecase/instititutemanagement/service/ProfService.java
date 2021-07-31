package com.usecase.instititutemanagement.service;
import java.util.List;
import java.util.Optional;
import com.usecase.instititutemanagement.model.Prof;

public interface ProfService {
	
	public List<Prof> getAllProfs();
	public Optional<Prof> fetchbyid(Integer id);
	public void saveProf (Prof prof);
	public boolean updateProf (Prof prof);
	public boolean deleteProf (Prof prof);
}