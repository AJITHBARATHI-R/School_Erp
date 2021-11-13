package com.erp.school.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.erp.TableLogger;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_master_user")
@Getter
@Setter
@NoArgsConstructor
public class MasterUser extends TableLogger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "ref_inst_id")
	private long refInstId;

	@Column(name = "lov_user_id")
	private long lovUserId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "user_login_id")
	private String userLoginId;

	@Column(name = "password")
	private String password;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "doj")
	private Date doj;
	
	@Column(name = "mobileno")
	private String mobileNo;
	
	@Column(name = "emergency_contact")
	private String emergencyContact;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "temporary_address")
	private String temporaryAddress;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "pincode")
	private String pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private MasterFaculty facultyInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private MasterStudent studentInfo;

}
