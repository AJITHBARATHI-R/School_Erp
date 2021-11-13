package com.erp.school.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.erp.TableLogger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_map_subjectfaculty")
@Getter
@Setter
@NoArgsConstructor
public class SubjectFacultyMapping extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="ref_inst_id")
	private long refInstId;
	
	@Column(name = "ref_faculty_id")
	private long refFacultyId;
	
	@Column(name = "ref_subject_id")
	private long refSubjectId;
	
	@Transient
	private String subjectName;
	
	@Transient
	private String facultyName;

}