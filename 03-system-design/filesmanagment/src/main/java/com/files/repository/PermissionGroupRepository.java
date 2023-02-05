package com.files.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.files.domain.PermissionGroup;

@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long>  {

	Optional<PermissionGroup> findByGroupName(String groupName);
}
