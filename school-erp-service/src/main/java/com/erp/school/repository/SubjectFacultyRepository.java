package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.SubjectFacultyMapping;

public interface SubjectFacultyRepository extends CrudRepository<SubjectFacultyMapping, Long> {

	SubjectFacultyMapping findById(long id);

	List<SubjectFacultyMapping> findByRefInstIdAndRefSubjectId(long refInstId, long refSubjectId);

	List<SubjectFacultyMapping> findByRefInstIdAndRefFacultyId(long refInstId, long refFacultyId);
}
