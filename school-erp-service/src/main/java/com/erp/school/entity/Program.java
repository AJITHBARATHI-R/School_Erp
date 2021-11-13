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
@Table(name = "tbl_master_program")
@Getter
@Setter
@NoArgsConstructor
public class Program extends TableLogger implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name="ref_inst_id")
	private long refInstId;
	
	@Column(name="ref_board_id")
	private long refBoardId;
	
	@Column(name = "program_name")
	private String programName;
	
	@Column(name = "description")
	private String programDescription;
	
	@Column(name = "image_path")
	private String programImagePath;
	
}