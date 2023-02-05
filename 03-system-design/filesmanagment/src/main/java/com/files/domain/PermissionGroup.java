package com.files.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "permission_group")
@Data
public class PermissionGroup {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "group_name")
	private String groupName;
	
}
