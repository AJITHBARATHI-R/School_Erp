package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Dayorder;

public interface DayorderRepository extends CrudRepository<Dayorder, Long> {
	Dayorder findById(long id);

	List<Dayorder> findByRefInstIdAndRefBoardIdAndRefProgramIdAndRefYearId(long instId, long boardId, long programId,
			long yearId);
}
