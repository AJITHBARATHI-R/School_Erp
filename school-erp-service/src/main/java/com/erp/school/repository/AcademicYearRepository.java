package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.AcademicYear;

public interface AcademicYearRepository extends CrudRepository<AcademicYear, Long> {

	AcademicYear findById(long id);

	List<AcademicYear> findByRefInstId(long refInstId);
}
