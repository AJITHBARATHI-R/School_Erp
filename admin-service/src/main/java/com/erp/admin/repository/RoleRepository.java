package com.erp.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	List<Role> findByDepartmentid(long departmentid);

	@Query("select r from Role r where id=?1")
	Role getById(long id);

}
