package com.erp.school.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.erp.TableLogger;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_master_faculty")
@Getter
@Setter
@NoArgsConstructor
public class MasterFaculty extends TableLogger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	/*
	 * @Column(name = "ref_user_id") private long refUserId;
	 */
	
	@Column(name = "ref_inst_id")
	private long refInstId;
	
	@Column(name = "ref_board_id")
	private long refBoardId;
	
	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "completed_degree")
	private String completedDegree;
	
	@Column(name = "main_subjects")
	private String mainSubjects;
	
	@Column(name = "alternative_subjects")
	private String alternativeSubjects;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ref_user_id",referencedColumnName = "id", nullable = false, updatable = true, insertable = true)
	@JsonBackReference
	private MasterUser userInfo;


}
