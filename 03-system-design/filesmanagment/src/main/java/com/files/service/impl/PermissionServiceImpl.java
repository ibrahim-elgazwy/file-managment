package com.files.service.impl;

import org.springframework.stereotype.Service;

import com.files.domain.Permission;
import com.files.domain.PermissionGroup;
import com.files.domain.User;
import com.files.enums.PermissionGroupEnum;
import com.files.enums.PermissionLevel;
import com.files.enums.Role;
import com.files.exception.FilesManagmentException;
import com.files.repository.PermissionRepository;
import com.files.service.PermissionGroupService;
import com.files.service.PermissionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {
	
	private final PermissionRepository permissionRepository;
	private final PermissionGroupService permissionGroupService;

	@Override
	public void creatUserPermissions(User user) throws FilesManagmentException {
		
		String permissionLevel = getPermissionLevel(user);
		
		PermissionGroup group = getPermissionGroup(user);
				
		Permission permission = Permission.builder()
				.userEmail(user.getEmail())
				.permissionLevel(permissionLevel)
				.group(group)
				.build();
		
		permissionRepository.save(permission);
	}

	private PermissionGroup getPermissionGroup(User user) throws FilesManagmentException {
		
		String groupName = isAdmin(user) 
				? PermissionGroupEnum.ADMIN_GROUP.toString()
			    : PermissionGroupEnum.USER_GROUP.toString();
		
		return permissionGroupService.findByGroupName(groupName);
	}

	private String getPermissionLevel(User user) {
		
		return isAdmin(user) ? PermissionLevel.EDIT.toString() 
							 : PermissionLevel.VIEW.toString();
	}
	
	private boolean isAdmin(User user) {
		
		return user.getRole().toString()
				.equals(Role.ADMIN.toString());
	}
}
