package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Section;

public interface SectionRepository extends CrudRepository<Section, Long> {

	Section findById(long id);

	List<Section> findByRefInstIdAndRefCourseId(long refInstId, long refCourseId);
}
