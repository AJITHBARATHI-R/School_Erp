package com.erp.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.school.lov.entity.LovDiscipline;
import com.erp.school.lov.entity.LovInstitutionType;
import com.erp.school.lov.entity.LovUserType;
import com.erp.school.lov.entity.Weekdays;
import com.erp.school.service.LookupPersistService;
import com.etpl.common.util.ResponseObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/p/lookup/")
@Api(value = "Lookup Pesistance API", description = "Lookup Persistance API can be used to create or update New Discipline/ Institution_Type/ User_Type entity", tags = {
		"Lookup Persistance API" })
public class LookupPersistController {

	@Autowired
	private LookupPersistService lookupService;
	
	/** ########################### Lookup Institution Type Information ######################################## */

	@ApiOperation(value = "Create a New Lookup Institution Type" ,response = ResponseObject.class)
	@PostMapping(value = "new/institutiontype/")
	public ResponseEntity<ResponseObject> newInstitutionType(@RequestBody LovInstitutionType reqObj) {
		lookupService.newInstitutionType(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Lookup Data for Institution Type Created Successfully"), HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Lookup Institution Type",response = ResponseObject.class)
	@PostMapping(value = "update/institutiontype/")
	public ResponseEntity<?> updateInstitutionType(@RequestBody LovInstitutionType reqObj) {
		lookupService.updateInstitutionType(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Lookup Data for Institution Type Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Lookup User Type ######################################## */

	@ApiOperation(value = "Create a New Lookup User Type" ,response = ResponseObject.class)
	@PostMapping(value = "new/usertype/")
	public ResponseEntity<ResponseObject> newUserType(@RequestBody LovUserType reqObj) {
		lookupService.newUserType(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Lookup Data for User Type Created Successfully"), HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Lookup Institution Type",response = ResponseObject.class)
	@PostMapping(value = "update/usertype/")
	public ResponseEntity<?> updateUserType(@RequestBody LovUserType reqObj) {
		lookupService.updateUserType(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Lookup Data for User Type Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Lookup Discipline ######################################## */

	@ApiOperation(value = "Create a New Lookup Discipline" ,response = ResponseObject.class)
	@PostMapping(value = "new/discipline/")
	public ResponseEntity<ResponseObject> newDiscipline(@RequestBody LovDiscipline reqObj) {
		lookupService.newDiscipline(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Lookup Data for Discipline Created Successfully"), HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Lookup Institution Type",response = ResponseObject.class)
	@PostMapping(value = "update/discipline/")
	public ResponseEntity<?> updateDiscipline(@RequestBody LovDiscipline reqObj) {
		lookupService.updateDiscipline(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Lookup Data for Discipline Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Lookup Days ######################################## */

	@ApiOperation(value = "Create a New Week Days" ,response = ResponseObject.class)
	@PostMapping(value = "new/weekdays/")
	public ResponseEntity<ResponseObject> newWeekdays(@RequestBody Weekdays reqObj) {
		lookupService.newWeekdays(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Weekday Created Successfully"), HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Lookup Institution Type",response = ResponseObject.class)
	@PostMapping(value = "update/weekdays/")
	public ResponseEntity<?> updateWeekdays(@RequestBody Weekdays reqObj) {
		lookupService.updateWeekdays(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Weekday Updated Successfully"),
				HttpStatus.OK);
	}
}
