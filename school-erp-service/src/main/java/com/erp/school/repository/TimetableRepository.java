package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.AcademicTimetable;

public interface TimetableRepository extends CrudRepository<AcademicTimetable, Long> {

	AcademicTimetable findById(long id);

	List<AcademicTimetable> findByRefInstIdAndRefBoardIdAndRefProgramIdAndRefYearIdAndRefSectionId(long instId, long boardId,
			long programId, long yearId, long sectionId);
}
