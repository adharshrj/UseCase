package com.usecase.instititutemanagement.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.instititutemanagement.model.Prof;
@Repository("profrepo")
public interface ProfRepo extends JpaRepository<Prof, Integer> {
	
}