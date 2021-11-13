package com.erp.admin.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.erp.admin.entity.BranchRoleMenuMapping;
import com.erp.admin.entity.BranchUserMapping;
import com.erp.admin.entity.BranchUserMenuMapping;
import com.erp.admin.entity.Department;
import com.erp.admin.entity.Designation;
import com.erp.admin.entity.Menu;
import com.erp.admin.entity.MenuNew;
import com.erp.admin.entity.Role;
import com.etpl.common.exception.DAOPersistanceException;

@Transactional
@Service
public class AdminPersistsService {

	@PersistenceContext
	private EntityManager entityManager;

	public void newDepartment(Department reqObj) {
		try {
			reqObj.setCompanycode("031");
			reqObj.setDepartmentcode("A");
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateDepartment(Department reqObj) {
		try {
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

//Designation
	public void newDesignation(Designation reqObj) {
		try {
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateDesignation(Designation reqObj) {
		try {
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

//Role

	public void newRole(Role reqObj) {
		try {
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateRole(Role reqObj) {
		try {
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

//Menu
	public void newMenu(Menu reqObj) {
		try {
			reqObj.setCompanycode("031");	
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateMenu(Menu reqObj) {
		try {
			reqObj.setCompanycode("031");
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void newMapping(BranchUserMapping reqObj) {
		try {
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateMapping(BranchUserMapping reqObj) {
		try {
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void newUserMenuMapping(BranchUserMenuMapping reqObj) {
		try {
			reqObj.setBranchcode("031");
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateUserMenuMapping(BranchUserMenuMapping reqObj) {
		try {
			reqObj.setBranchcode("031");
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void newRoleMenuMapping(BranchRoleMenuMapping reqObj) {
		try {
			reqObj.setBranchcode("031");
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateRoleMenuMapping(BranchRoleMenuMapping reqObj) {
		try {
			reqObj.setBranchcode("031");
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	/*public void newMenu(MenuNew reqObj) {
		try {
			entityManager.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateMenu(MenuNew reqObj) {
		try {
			entityManager.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}*/

}
