package com.files.service;

import com.files.domain.User;
import com.files.exception.FilesManagmentException;

public interface PermissionService {

	void creatUserPermissions(User user) throws FilesManagmentException;
}
