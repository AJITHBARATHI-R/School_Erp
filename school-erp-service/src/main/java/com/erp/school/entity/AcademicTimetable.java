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
@Table(name = "tbl_aca_timetable")
@Getter
@Setter
@NoArgsConstructor
public class AcademicTimetable extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "ref_inst_id")
	private long refInstId;
	
	@Column(name = "ref_board_id")
	private long refBoardId;
	
	@Column(name = "ref_program_id")
	private long refProgramId;
	
	@Column(name = "ref_year_id")
	private long refYearId;
	
	@Column(name = "ref_dayorder_id")
	private long refDayorderId;
	
	@Column(name = "ref_faculty_id")
	private long refFacultyId;
	
	@Column(name = "ref_subject_id")
	private long refSubjectId;
	
	@Column(name = "ref_section_id")
	private long refSectionId;
	
	@Column(name = "period")
	private int period;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;

}
