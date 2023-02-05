package com.files.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.files.domain.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	Optional<Permission> findByUserEmail(String userEmail);
}
