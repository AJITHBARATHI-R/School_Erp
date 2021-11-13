package com.erp.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.school.lov.entity.LovDiscipline;
import com.erp.school.lov.entity.LovInstitutionType;
import com.erp.school.lov.entity.Weekdays;
import com.erp.school.service.LookupViewService;
import com.etpl.common.util.RESTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/v/lookup/")
@Api(value = "Lookup Read API Service", description = "Read API Services can be used to read lookup informations", tags = {
		"Lookup Read API Services" })
public class LookupViewController {

	@Autowired
	private LookupViewService viewService;

	// Retrieve all institution type details
	@ApiOperation(value = "To Read all Institution Type Lookup datas", response = LovInstitutionType.class)
	@GetMapping(value = "allinstitutiontypes/")
	public ResponseEntity<List<?>> getAllInstitutionTypes() {
		List<?> resultList = RESTUtil.ResponseEntityList(viewService.getAllInstitutionTypes(), "Institution Type");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}

	// Retrieve all user type details
	@ApiOperation(value = "To Read all User Type Lookup datas", response = LovInstitutionType.class)
	@GetMapping(value = "allusertypes/")
	public ResponseEntity<List<?>> getAllUserTypes() {
		List<?> resultList = RESTUtil.ResponseEntityList(viewService.getAllUserTypes(), "User Type");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}

	// Retrieve all institution type details
	@ApiOperation(value = "To Read all discipline Lookup datas", response = LovDiscipline.class)
	@GetMapping(value = "alldiscipline/")
	public ResponseEntity<List<?>> getAllDiscipline() {
		List<?> resultList = RESTUtil.ResponseEntityList(viewService.getAllDiscipline(), "Discipline");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}
	
	// Retrieve all Weekdays
	@ApiOperation(value = "To Read all Weekdays Lookup datas", response = Weekdays.class)
	@GetMapping(value = "allweekdays/")
	public ResponseEntity<List<?>> getAllWeekdays() {
		List<?> resultList = RESTUtil.ResponseEntityList(viewService.getAllWeekdays(), "Weekdays");
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}
}
