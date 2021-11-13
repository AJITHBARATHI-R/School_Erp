package com.erp.school.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "tbl_master_subjectgrouping")
@Getter
@Setter
@NoArgsConstructor
public class SubjectGrouping extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "ref_inst_id")
	private long refInstId;
	
	@Column(name = "ref_course_id")
	private long refCourseId;
	
	@Column(name = "branch_subject")
	private Date branchSubject;
	
	@Column(name = "group_subjects")
	private String groupSubjects;

}
