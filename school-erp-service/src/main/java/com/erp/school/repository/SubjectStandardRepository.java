package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.SubjectStandardMapping;

public interface SubjectStandardRepository extends CrudRepository<SubjectStandardMapping, Long> {

	SubjectStandardMapping findById(long id);

	List<SubjectStandardMapping> findByRefInstIdAndRefSectionId(long refInstId, long refSectionId);
}
