package com.erp.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

	@Query("select d from Department d where id=?1")
	Department getById(long id);

	List<?> findByDepartmentcode(String string);

}
