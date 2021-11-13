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
@Table(name = "tbl_master_subject")
@Getter
@Setter
@NoArgsConstructor
public class Subject extends TableLogger implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="ref_inst_id")
	private long refInstId;
	
	@Column(name="ref_course_id")
	private long refCourseId;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "description")
	private String subjectDescription;
	
	@Column(name = "image_path")
	private String subjectImagePath;
}
	