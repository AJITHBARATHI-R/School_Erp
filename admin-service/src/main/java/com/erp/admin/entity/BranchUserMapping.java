package com.erp.admin.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "branchusermapping")
@Getter
@Setter
@NoArgsConstructor
public class BranchUserMapping extends TableLogger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "branchcode")
	private String branchcode;

	@Column(name = "userid")
	private String userid;

	@Column(name = "roleid")
	private String roleid;
	
	@Column(name = "effectivefrom")
	private Date effectivefrom;

	@Column(name = "effectiveto")
	private Date effectiveto;
	
	@Column(name = "defaultlogin")
	private int defaultlogin;

	@Column(name = "description")
	private String description;

}
