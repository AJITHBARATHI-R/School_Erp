package com.erp.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.Designation;

public interface DesignationRepository extends CrudRepository<Designation, Long> {

	List<Designation> findByDepartmentid(long departmentid);

	@Query("select d from Designation d where id=?1")
	Designation getById(long id);

}
