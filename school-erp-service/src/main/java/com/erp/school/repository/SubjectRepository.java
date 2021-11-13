package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

	Subject findById(long id);

	List<Subject> findByRefInstIdAndRefCourseId(long refInstId, long refCourseId);
}
