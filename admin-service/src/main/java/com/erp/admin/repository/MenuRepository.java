package com.erp.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.admin.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {

	@Query("select m from Menu m where id=?1")
	Menu getById(long id);

	 List<?> findByParentmenu(String parentmenu);

}
