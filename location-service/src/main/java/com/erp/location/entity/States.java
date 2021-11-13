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
@Table(name = "states")
@Getter
@Setter
@NoArgsConstructor
public class States extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "country_id")
	private long countryId;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "fips_code")
	private String fipsCode;
	
	@Column(name = "state_code")
	private String stateCode;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "wikidataid")
	private String wikidataid;
}
