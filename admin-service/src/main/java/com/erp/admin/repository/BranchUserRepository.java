package com.erp.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.BranchUserMapping;

public interface BranchUserRepository extends CrudRepository<BranchUserMapping, Long> {

	@Query("select m from BranchUserMapping m where id=?1")
	BranchUserMapping getById(long id);

	BranchUserMapping findByBranchcode(String branchcode);

	BranchUserMapping findByUserid(String userid);

	List<?> findByRoleid(String roleid);

}
