package com.usecase.instititutemanagement.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.instititutemanagement.model.Prof;
@Repository
public interface ProfRepo extends JpaRepository<Prof, Integer> {
	
}