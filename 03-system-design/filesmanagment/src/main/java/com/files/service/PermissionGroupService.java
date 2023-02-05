package com.files.service;

import com.files.domain.PermissionGroup;
import com.files.exception.FilesManagmentException;

public interface PermissionGroupService {

	PermissionGroup findByGroupName(String groupName) throws FilesManagmentException;
}
