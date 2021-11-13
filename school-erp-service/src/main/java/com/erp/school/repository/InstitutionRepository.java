package com.erp.school.repository;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Institution;

public interface InstitutionRepository extends CrudRepository<Institution, Long> {

	Institution findById(long id);
}
