package com.erp.school.entity;

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
@Table(name = "tbl_master_settings")
@Getter
@Setter
@NoArgsConstructor
public class Settings extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "date_format")
	private String dateFormat;

	@Column(name = "time_zone")
	private String timeZone;

	@Column(name = "avail_space")
	private String availSpace;

}
