package com.erp.admin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.BranchRoleMenuMapping;

public interface BranchRoleMenuRepository extends CrudRepository<BranchRoleMenuMapping, Long> {

	@Query("select m from BranchRoleMenuMapping m where id=?1")
	BranchRoleMenuMapping getById(long id);

}
