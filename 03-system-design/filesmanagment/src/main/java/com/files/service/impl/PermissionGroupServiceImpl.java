package com.files.service.impl;

import org.springframework.stereotype.Service;

import com.files.domain.PermissionGroup;
import com.files.enums.FilesErrorEnum;
import com.files.exception.FilesManagmentException;
import com.files.repository.PermissionGroupRepository;
import com.files.service.PermissionGroupService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PermissionGroupServiceImpl implements PermissionGroupService {
	
	private final PermissionGroupRepository permissionGroupRepository;

	@Override
	public PermissionGroup findByGroupName(String groupName) throws FilesManagmentException {

		return permissionGroupRepository.findByGroupName(groupName)
				.orElseThrow(() -> new FilesManagmentException(FilesErrorEnum.INVALID_GROUP_NAME));
	}

}
