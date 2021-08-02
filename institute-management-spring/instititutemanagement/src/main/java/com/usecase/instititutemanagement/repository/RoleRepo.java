package com.usecase.instititutemanagement.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.instititutemanagement.model.Role;
import com.usecase.instititutemanagement.model.ARole;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ARole name);
}