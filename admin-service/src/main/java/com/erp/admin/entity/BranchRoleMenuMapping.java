package com.erp.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.TableLogger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "branchrolemenumapping")
@Getter
@Setter
@NoArgsConstructor
public class BranchRoleMenuMapping extends TableLogger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "branchcode")
	private String branchcode;

	@Column(name = "roleid")
	private String roleid;

	@Column(name = "menu")
	private String menu;
	
	@Column(name = "description")
	private String description;


}
