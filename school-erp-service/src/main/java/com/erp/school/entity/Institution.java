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
@Table(name = "tbl_master_institution")
@Getter
@Setter
@NoArgsConstructor
public class Institution extends TableLogger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "institution_name")
	private String institutionName;

	@Column(name = "institution_type")
	private String institutionType;

	@Column(name = "institution_group_id")
	private long institutionGroupId;
	
	@Column(name = "is_group_institution")
	private String isGroupInstitution;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "fax")
	private String fax;

	@Column(name = "address_line_1")
	private String addressLine1;
	
	@Column(name = "address_line_2")
	private String addressLine2;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postalcode")
	private String postalCode;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "email")
	private String email;

	@Column(name = "logo")
	private String logo;

	@Column(name = "year_of_foundation")
	private Long yearOfFoundation;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;

	@Column(name = "landmark")
	private String landmark;

}
