package com.erp.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erp.admin.entity.BranchRoleMenuMapping;
import com.erp.admin.entity.BranchUserMapping;
import com.erp.admin.entity.BranchUserMenuMapping;
import com.erp.admin.entity.Department;
import com.erp.admin.entity.Designation;
import com.erp.admin.entity.Menu;
import com.erp.admin.entity.Role;
import com.erp.admin.repository.BranchRoleMenuRepository;
import com.erp.admin.repository.BranchUserMenuRepository;
import com.erp.admin.repository.BranchUserRepository;
import com.erp.admin.repository.DepartmentRepository;
import com.erp.admin.repository.DesignationRepository;
import com.erp.admin.repository.MenuRepository;
import com.erp.admin.repository.RoleRepository;
import com.etpl.common.exception.RecordNotFoundException;

@Service
public class AdminViewService {
	
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private DesignationRepository desiRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private BranchUserRepository branchUserRepo;
	
	@Autowired
	private BranchUserMenuRepository branchUserMenuRepo;
	
	@Autowired
	private BranchRoleMenuRepository branchRoleMenuRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<?> getByDepartmentCode(String string) {
		return Optional.ofNullable(deptRepo.findByDepartmentcode(string))
				.orElseThrow(() -> new RecordNotFoundException("No department found for given department code"));
	}

	public Department getDepartmentById(long id) {
		return Optional.ofNullable(deptRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Department Details Available in the System for the given ID"));
	}

	public List<?> getDesignationByDeptId(long departmentid) {
		List<Designation> desigList = Optional.ofNullable(desiRepo.findByDepartmentid(departmentid))
		.orElseThrow(() -> new RecordNotFoundException("No designation found for given department id"));
		for (Designation designationObj : desigList) {
			Department refDepartment = deptRepo.getById(designationObj.getDepartmentid());
			designationObj.setDepartment(refDepartment.getDepartment());
		}
		/*return Optional.ofNullable(desiRepo.findByDepartmentid(departmentid))
				.orElseThrow(() -> new RecordNotFoundException("No designation found for given department id"));*/
		return desigList;
	}

	public Designation getDesignationById(long id) {
		Designation refDesignation = Optional.ofNullable(desiRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Designation Details Available in the System for the ID"));
		Department refDepartment = deptRepo.getById(refDesignation.getDepartmentid());
		refDesignation.setDepartment(refDepartment.getDepartment());
		return refDesignation;
	}

	public Role getRolesById(long id) {
		Role refRole = Optional.ofNullable(roleRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Role Details Available in the System for the ID"));
		Department refDepartment = deptRepo.getById(refRole.getDepartmentid());
		refRole.setDepartment(refDepartment.getDepartment());
		return refRole;
	}

	public List<?> getRoleByDeptId(long departmentid) {
		List<Role> roleList = Optional.ofNullable(roleRepo.findByDepartmentid(departmentid)).orElseThrow(
					() -> new RecordNotFoundException("No Role Details Available in the System for the department ID"));
		for (Role roleObj : roleList) {
			Department refDepartment = deptRepo.getById(roleObj.getDepartmentid());
			roleObj.setDepartment(refDepartment.getDepartment());
		}
		return roleList;
	}

	public Menu getMenusById(long id) {
		return Optional.ofNullable(menuRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Menu Details Available in the System for the given ID"));
	}

	public List<?> getByParentMenu(String parentmenu) {
		return Optional.ofNullable(menuRepo.findByParentmenu(parentmenu)).orElseThrow(
				() -> new RecordNotFoundException("No Menu Details Available in the System for the given parent ID"));
	}


	public BranchUserMapping getBranchUserById(long id) {
		return Optional.ofNullable(branchUserRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Branch User Details Available in the System for the given ID"));
	}

	public BranchUserMapping getBranchUserByCode(String branchcode) {
		return Optional.ofNullable(branchUserRepo.findByBranchcode(branchcode)).orElseThrow(
				() -> new RecordNotFoundException("No Branch User Details Available in the System for the given branch code"));
	}

	public BranchUserMapping getBranchUserByUserId(String userid) {
		return Optional.ofNullable(branchUserRepo.findByUserid(userid)).orElseThrow(
				() -> new RecordNotFoundException("No Branch User Details Available in the System for the given user id"));
	}

	public List<?> getBranchUserByRoleId(String roleid) {
		return Optional.ofNullable(branchUserRepo.findByRoleid(roleid)).orElseThrow(
				() -> new RecordNotFoundException("No Branch User Details Available in the System for the given role id"));
	}

	public BranchUserMenuMapping getBranchUserMenuById(long id) {
		return Optional.ofNullable(branchUserMenuRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Branch User Menu Mapped Details Available in the System for the ID"));
	}

	public BranchUserMenuMapping getBranchUserMenuByUserId(String userid) {
		return Optional.ofNullable(branchUserMenuRepo.findByUserid(userid)).orElseThrow(
				() -> new RecordNotFoundException("No Branch User Menu Mapped Details Available in the System for the given user id"));
	}

	public BranchRoleMenuMapping getBranchRoleMenuById(long id) {
		return Optional.ofNullable(branchRoleMenuRepo.getById(id)).orElseThrow(
				() -> new RecordNotFoundException("No Branch Role Menu Mapped Details Available in the System for the ID"));
	}

	public List<?> getAllDepartments() {
		return (List<Department>) Optional.ofNullable(deptRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No branch Details Available in the System"));
	}

	public List<?> getAllDesignations() {
		List<Designation> designationList = (List<Designation>) Optional.ofNullable(desiRepo.findAll())
		.orElseThrow(() -> new RecordNotFoundException("No branch Details Available in the System"));
		for (Designation designationObj : designationList) {
			Department refDepartment = deptRepo.getById(designationObj.getDepartmentid());
			designationObj.setDepartment(refDepartment.getDepartment());
		}
		return designationList;
	}

	public List<?> getAllRoles() {
		List<Role> roleList = (List<Role>) Optional.ofNullable(roleRepo.findAll())
		.orElseThrow(() -> new RecordNotFoundException("No branch Details Available in the System"));
		for (Role roleObj : roleList) {
			Department refDepartment = deptRepo.getById(roleObj.getDepartmentid());
			roleObj.setDepartment(refDepartment.getDepartment());
		}
		return roleList;
	}

	public List<?> getAllMenus() {
		return (List<?>) Optional.ofNullable(menuRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No branch Details Available in the System"));
				
	}
}
