package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.MasterStudent;

public interface StudentRepository extends CrudRepository<MasterStudent, Long> {

	MasterStudent findById(long id);

	List<MasterStudent> findByRefInstId(long refInstId);
}
