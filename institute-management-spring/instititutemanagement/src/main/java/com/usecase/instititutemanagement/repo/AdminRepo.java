package com.usecase.instititutemanagement.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.instititutemanagement.model.Admin;
import com.usecase.instititutemanagement.model.Prof;
@Repository("adminrepo")
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	public Prof getByName(final String name);
}