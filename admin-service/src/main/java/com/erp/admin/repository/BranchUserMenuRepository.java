package com.erp.admin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.BranchUserMenuMapping;

public interface BranchUserMenuRepository extends CrudRepository<BranchUserMenuMapping, Long> {

	@Query("select m from BranchUserMenuMapping m where id=?1")
	BranchUserMenuMapping getById(long id);

	BranchUserMenuMapping findByUserid(String userid);

}
