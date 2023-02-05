package com.files.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="permission_group_id", nullable=false)
	private PermissionGroup permissionGroup;
	
	@OneToOne
	@JoinColumn(name="parent_item_id")
	private Item parentItem;
}
