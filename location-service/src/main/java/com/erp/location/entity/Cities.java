package com.erp.location.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.location.TableLogger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
public class Cities extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "state_id")
	private Long state_id;
	
	@Column(name = "state_code")
	private String state_code;

	@Column(name = "country_id")
	private Long country_id;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "wikidataid")
	private String wikidataid;
}
