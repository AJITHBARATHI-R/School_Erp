package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Standard;

public interface StandardRepository extends CrudRepository<Standard, Long> {
	
	Standard findById(long id);

	List<Standard> findByRefInstIdAndRefProgramId(long refInstId, long refProgramId);

}
