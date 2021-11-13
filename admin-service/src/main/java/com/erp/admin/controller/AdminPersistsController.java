/**@package com.tsshc.admin
 * @project <admin-service>
 * @author  <ElavrasanRamasamy>
 * @date    <Jun 21, 2021>
 * @location
 */
package com.erp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.erp.admin.service.AdminPersistsService;
import com.etpl.common.util.ResponseObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/p/admin/")
@Api(value = "Admin Pesistance API", description = "Admin Persistance API can be used to create New Role/ Menu/ Designation and Department entity", tags = {"Admin Persistance API" })
public class AdminPersistsController {
	
	@Autowired
	private AdminPersistsService adminService;

	//create new department
	@ApiOperation(value = "Create New Department",response = ResponseObject.class)
	@PostMapping(value = "new/dept/")
	public ResponseEntity<?> newDepartment(@RequestBody Department reqObj) {
		adminService.newDepartment(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Department created Successfully"), HttpStatus.OK);
	}
	//revise or update existing department information
	@ApiOperation(value = "Revise/Update existing Department information",response = ResponseObject.class)
	@PostMapping(value = "update/dept/")
	public ResponseEntity<?> updateDepartment(@RequestBody Department reqObj) {
		adminService.updateDepartment(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Department Details Updated Successfully"), HttpStatus.OK);
	}
	
	//create new designation for a selected department
	@ApiOperation(value = "Create New Designation for a Selected Department",response = ResponseObject.class)
	@PostMapping(value = "new/designation/")
	public ResponseEntity<?> newDesignation(@RequestBody Designation reqObj) {
		adminService.newDesignation(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Designation Details created Successfully"), HttpStatus.OK);
	}
	
	//revise or update existing designation information
	@ApiOperation(value = "Revise/Update existing Designation Details",response = ResponseObject.class)
	@PostMapping(value = "update/designation/")
	public ResponseEntity<?> updateDesignation(@RequestBody Designation reqObj) {
		adminService.updateDesignation(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Designation Details Updated Successfully"), HttpStatus.OK);
	}
	
	//create new role
	@ApiOperation(value = "Create New Role",response = ResponseObject.class)
	@PostMapping(value = "new/role/")
	public ResponseEntity<?> newRole(@RequestBody Role reqObj) {
		adminService.newRole(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Role created Successfully"), HttpStatus.OK);
	}
	
	//revise or update existing role information
	@ApiOperation(value = "Revise/Update existing role Details",response = ResponseObject.class)
	@PostMapping(value = "update/role/")
	public ResponseEntity<?> updateRole(@RequestBody Role reqObj) {
		adminService.updateRole(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Role Updated Successfully"), HttpStatus.OK);
	}
	
	//create new menu
	@ApiOperation(value = "Create New Menu",response = ResponseObject.class)
	@PostMapping(value = "new/menu/")
	public ResponseEntity<?> newMenu(@RequestBody Menu reqObj) {
		adminService.newMenu(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Menu created Successfully"), HttpStatus.OK);
	}
	
	//revise or update existing menu information
	@ApiOperation(value = "Revise/Update existing Menu Details",response = ResponseObject.class)
	@PostMapping(value = "update/menu/")
	public ResponseEntity<?> updateMenu(@RequestBody Menu reqObj) {
		adminService.updateMenu(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Menu Updated Successfully"), HttpStatus.OK);
	}
	
	// create new branch user mapping details
	@ApiOperation(value = "Create New Branch User Mapping details", response = ResponseObject.class)
	@PostMapping(value = "new/map/")
	public ResponseEntity<?> newMapping(@RequestBody BranchUserMapping reqObj) {
		adminService.newMapping(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Branch User Role Mapped Successfully"), HttpStatus.OK);
	}

	// revise or update existing menu information
	@ApiOperation(value = "Revise/Update existing Menu Details", response = ResponseObject.class)
	@PostMapping(value = "update/map/")
	public ResponseEntity<?> updateMapping(@RequestBody BranchUserMapping reqObj) {
		adminService.updateMapping(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Branch User Role Mapping details Updated Successfully"), HttpStatus.OK);
	}
	
	// create new branch user menu mapping details
	@ApiOperation(value = "Create New Branch User Menu Mapping details", response = ResponseObject.class)
	@PostMapping(value = "new/usermenu/")
	public ResponseEntity<?> newUserMenuMapping(@RequestBody BranchUserMenuMapping reqObj) {
		adminService.newUserMenuMapping(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Branch User Menu Mapped Successfully"), HttpStatus.OK);
	}

	// revise or update existing menu information
	@ApiOperation(value = "Revise/Update existing Branch User Menu Details", response = ResponseObject.class)
	@PostMapping(value = "update/usermenu/")
	public ResponseEntity<?> updateUserMenuMapping(@RequestBody BranchUserMenuMapping reqObj) {
		adminService.updateUserMenuMapping(reqObj);
		return new ResponseEntity<ResponseObject>(
				new ResponseObject("Branch User Menu Mapping details Updated Successfully"), HttpStatus.OK);
	}
	
	// create new branch role menu mapping details
	@ApiOperation(value = "Create New Branch Role Menu Mapping details", response = ResponseObject.class)
	@PostMapping(value = "new/rolemenu/")
	public ResponseEntity<?> newRoleMenuMapping(@RequestBody BranchRoleMenuMapping reqObj) {
		adminService.newRoleMenuMapping(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Branch Role Menu Mapped Successfully"),
				HttpStatus.OK);
	}

	// revise or update existing menu information
	@ApiOperation(value = "Revise/Update existing Branch User Menu Details", response = ResponseObject.class)
	@PostMapping(value = "update/rolemenu/")
	public ResponseEntity<?> updateRoleMenuMapping(@RequestBody BranchRoleMenuMapping reqObj) {
		adminService.updateRoleMenuMapping(reqObj);
		return new ResponseEntity<ResponseObject>(
				new ResponseObject("Branch Role Menu Mapping details Updated Successfully"), HttpStatus.OK);
	}
	
	// create new menu
	/*@ApiOperation(value = "Create New Menu", response = ResponseObject.class)
	@PostMapping(value = "new/menu/")
	public ResponseEntity<?> newMenu(@RequestBody MenuNew reqObj) {
		adminService.newMenu(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Menu created Successfully"), HttpStatus.OK);
	}

	// revise or update existing menu information
	@ApiOperation(value = "Revise/Update existing Menu Details", response = ResponseObject.class)
	@PostMapping(value = "update/menu/")
	public ResponseEntity<?> updateMenu(@RequestBody MenuNew reqObj) {
		adminService.updateMenu(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Menu Updated Successfully"), HttpStatus.OK);
	}*/

}
