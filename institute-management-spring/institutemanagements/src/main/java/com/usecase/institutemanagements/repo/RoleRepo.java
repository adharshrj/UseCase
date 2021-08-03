package com.usecase.institutemanagements.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.institutemanagements.model.Role;
import com.usecase.institutemanagements.model.ARole;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ARole name);
}
