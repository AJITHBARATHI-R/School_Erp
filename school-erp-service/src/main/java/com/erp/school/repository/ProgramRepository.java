package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Program;

public interface ProgramRepository extends CrudRepository<Program, Long> {
	
	Program findById(long id);

	List<Program> findByRefInstIdAndRefBoardId(long refInstId, long refBoardId);

}
