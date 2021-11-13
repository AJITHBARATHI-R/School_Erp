package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.MasterFaculty;

public interface FacultyRepository extends CrudRepository<MasterFaculty, Long> {

	MasterFaculty findById(long id);

	List<MasterFaculty> findByRefInstId(long refInstId);
}
