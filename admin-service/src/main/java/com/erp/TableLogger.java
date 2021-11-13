package com.erp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class TableLogger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "activestatus")
	private int activestatus=1;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "createdtime")
	private Date createdTime;
	
	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@Column(name = "modifiedtime")
	private Date modifiedTime;
	
	public TableLogger() {
		if(activestatus == 0)
			activestatus = 0;
		if(createdBy == null)
			createdBy = "default";
		if(createdTime == null)
			createdTime = new Date();
		if(modifiedBy == null)
			modifiedBy = "default";
		if(modifiedTime == null)
			modifiedTime = new Date();
	}
	
	public int getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(int activestatus) {
		this.activestatus = activestatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setInsertion(String user) {
		setActivestatus(1);
		setCreatedBy(user);
		setCreatedTime(new Date());
		setModifiedBy(user);
		setModifiedTime(new Date());
	}

}
