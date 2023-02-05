package com.files.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "permission_level")
	private String permissionLevel;
	
	@JoinColumn(name = "group_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private PermissionGroup group;
}
