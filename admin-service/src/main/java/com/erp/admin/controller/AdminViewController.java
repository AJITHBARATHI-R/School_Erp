/**@package com.tsshc.admin
 * @project <admin-service>
 * @author  <ElavrasanRamasamy>
 * @date    <Jun 21, 2021>
 * @location
 */
package com.erp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.admin.entity.BranchRoleMenuMapping;
import com.erp.admin.entity.BranchUserMapping;
import com.erp.admin.entity.BranchUserMenuMapping;
import com.erp.admin.entity.Department;
import com.erp.admin.entity.Designation;
import com.erp.admin.entity.Menu;
import com.erp.admin.entity.Role;
import com.erp.admin.service.AdminViewService;
import com.etpl.common.util.RESTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/v/admin/")
@Api(value = "Admin Read API Service", description = "Admin Read API can be used to read New Role/ Menu/ Designation and Department entity", tags = {
		"Admin Read API" })
public class AdminViewController {

	@Autowired
	private AdminViewService adminService;

	// Retrieve Department Details
	@ApiOperation(value = "To Read Department Details for given department ID", response = Department.class)
	@PostMapping(value = "dept/deptcode")
	public ResponseEntity<List<?>> getByDepartmentCode(@RequestBody Department reqObj) {
		return new ResponseEntity<List<?>>(adminService.getByDepartmentCode(reqObj.getDepartmentcode()), HttpStatus.OK);
	}

	//Retrieve Department Information by ID
	@ApiOperation(value = "To Read Department details based on ID", response = Department.class)
	@PostMapping(value = "dept/id/")
	public ResponseEntity<?> getDepartmentById(@RequestBody Department reqObj) {
		return new ResponseEntity<Department>(adminService.getDepartmentById(reqObj.getId()), HttpStatus.OK);
	}
	
	// Retrieve Designation Information by department ID
	@ApiOperation(value = "To Read Designation details based on department ID", response = Designation.class)
	@PostMapping(value = "desig/deptid/")
	public ResponseEntity<?> getDesignationByDeptId(@RequestBody Designation reqObj) {
		return new ResponseEntity<List<?>>(adminService.getDesignationByDeptId(reqObj.getDepartmentid()), HttpStatus.OK);
	}
	
	// Retrieve Designation Information by ID
	@ApiOperation(value = "To Read Designation details based on ID", response = Designation.class)
	@PostMapping(value = "desig/id/")
	public ResponseEntity<?> getDesignationById(@RequestBody Designation reqObj) {
		return new ResponseEntity<Designation>(adminService.getDesignationById(reqObj.getId()), HttpStatus.OK);
	}
	
	// Retrieve Designation Information by department ID
	@ApiOperation(value = "To Read Role details based on ID", response = Role.class)
	@PostMapping(value = "role/id/")
	public ResponseEntity<?> getRolesById(@RequestBody Role reqObj) {
		return new ResponseEntity<Role>(adminService.getRolesById(reqObj.getId()), HttpStatus.OK);
	}
	
	// Retrieve Role Information by department ID
	@ApiOperation(value = "To Read Role details based on department ID", response = Role.class)
	@PostMapping(value = "role/deptid/")
	public ResponseEntity<?> getRoleByDeptId(@RequestBody Role reqObj) {
		return new ResponseEntity<List<?>>(adminService.getRoleByDeptId(reqObj.getDepartmentid()), HttpStatus.OK);
	}

	// Retrieve Menu Information by ID
	@ApiOperation(value = "To Read Menu details based on ID", response = Menu.class)
	@PostMapping(value = "menu/id/")
	public ResponseEntity<?> getMenusById(@RequestBody Menu reqObj) {
		return new ResponseEntity<Menu>(adminService.getMenusById(reqObj.getId()), HttpStatus.OK);
	}
	
	// Retrieve Menu Information by parent menu id
	@ApiOperation(value = "To Read Menu details based on parent menu ID", response = Menu.class)
	@PostMapping(value = "menu/parentmenu/")
	public ResponseEntity<?> getMenusByParentMenu(@RequestBody Menu reqObj) {
		return new ResponseEntity<List<?>>(adminService.getByParentMenu(reqObj.getParentmenu()), HttpStatus.OK);
	}
	
	// Retrieve Branch User Mapped Information by primary key
	@ApiOperation(value = "To Read Branch User details based on ID", response = BranchUserMapping.class)
	@PostMapping(value = "branchuser/id/")
	public ResponseEntity<?> getBranchUserById(@RequestBody BranchUserMapping reqObj) {
		return new ResponseEntity<BranchUserMapping>(adminService.getBranchUserById(reqObj.getId()), HttpStatus.OK);
	}
	
	// Retrieve Branch User Mapped Information by branch code
	@ApiOperation(value = "To Read Branch User details based on branch code", response = BranchUserMapping.class)
	@PostMapping(value = "branchuser/branchcode/")
	public ResponseEntity<?> getBranchUserByCode(@RequestBody BranchUserMapping reqObj) {
		return new ResponseEntity<BranchUserMapping>(adminService.getBranchUserByCode(reqObj.getBranchcode()), HttpStatus.OK);
	}
	
	// Retrieve Branch User Mapped Information by user id
	@ApiOperation(value = "To Read Branch User details based on user id", response = BranchUserMapping.class)
	@PostMapping(value = "branchuser/userid/")
	public ResponseEntity<?> getBranchUserByUserId(@RequestBody BranchUserMapping reqObj) {
		return new ResponseEntity<BranchUserMapping>(adminService.getBranchUserByUserId(reqObj.getUserid()),
				HttpStatus.OK);
	}
	
	// Retrieve Branch User Mapped Information by role id
	@ApiOperation(value = "To Read Branch User details based on role id", response = BranchUserMapping.class)
	@PostMapping(value = "branchuser/roleid/")
	public ResponseEntity<List<?>> getBranchUserByRoleId(@RequestBody BranchUserMapping reqObj) {
		return new ResponseEntity<List<?>>(adminService.getBranchUserByRoleId(reqObj.getRoleid()),
				HttpStatus.OK);
	}
	
	// Retrieve Branch User Menu Mapped Information by primary key
	@ApiOperation(value = "To Read Branch User Menu Mapped details based on ID", response = BranchUserMenuMapping.class)
	@PostMapping(value = "branchusermenu/id/")
	public ResponseEntity<?> getBranchUserMenuById(@RequestBody BranchUserMenuMapping reqObj) {
		return new ResponseEntity<BranchUserMenuMapping>(adminService.getBranchUserMenuById(reqObj.getId()), HttpStatus.OK);
	}
	
	// Retrieve Branch User Menu Mapped Information by user id
	@ApiOperation(value = "To Read Branch User Menu Mapped details based on user ID", response = BranchUserMenuMapping.class)
	@PostMapping(value = "branchusermenu/userid/")
	public ResponseEntity<?> getBranchUserMenuByUserId(@RequestBody BranchUserMenuMapping reqObj) {
		return new ResponseEntity<BranchUserMenuMapping>(adminService.getBranchUserMenuByUserId(reqObj.getUserid()),
				HttpStatus.OK);
	}
	
	// Retrieve Branch User Role Mapped Information by primary key
	@ApiOperation(value = "To Read Branch Role Menu Mapped details based on ID", response = BranchRoleMenuMapping.class)
	@PostMapping(value = "branchrolemenu/id/")
	public ResponseEntity<?> getBranchRoleMenuById(@RequestBody BranchRoleMenuMapping reqObj) {
		return new ResponseEntity<BranchRoleMenuMapping>(adminService.getBranchRoleMenuById(reqObj.getId()),
				HttpStatus.OK);
	}

	// Retrieve all Department Details
	@ApiOperation(value = "To Read all Department Details", response = Department.class)
	@GetMapping(value = "dept/all")
	public ResponseEntity<List<?>> getAllDepartments() {
		List<?> resultList = RESTUtil.ResponseEntityList(adminService.getAllDepartments(), "Department");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}
	
	// Retrieve all Designation Details
	@ApiOperation(value = "To Read all Designation Details", response = Department.class)
	@GetMapping(value = "desig/all")
	public ResponseEntity<List<?>> getAllDesignations() {
		List<?> resultList = RESTUtil.ResponseEntityList(adminService.getAllDesignations(), "Designation");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}

	// Retrieve all Role Details
	@ApiOperation(value = "To Read all Roles Details", response = Department.class)
	@GetMapping(value = "role/all")
	public ResponseEntity<List<?>> getAllRoles() {
		List<?> resultList = RESTUtil.ResponseEntityList(adminService.getAllRoles(), "Role");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}
	
	// Retrieve all Menu Details
	@ApiOperation(value = "To Read all Menu Details", response = Menu.class)
	@GetMapping(value = "menu/all")
	public ResponseEntity<List<?>> getAllMenus() {
		List<?> resultList = RESTUtil.ResponseEntityList(adminService.getAllMenus(), "Menu");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}
}
