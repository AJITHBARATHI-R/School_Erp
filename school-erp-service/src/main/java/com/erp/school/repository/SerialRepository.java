package com.erp.school.repository;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.SerialNumbers;

public interface SerialRepository extends CrudRepository<SerialNumbers, Long> {

	SerialNumbers findByRefInstId(long refInstId);

}
