package com.erp.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.location.entity.Cities;
import com.erp.location.entity.Countries;
import com.erp.location.entity.States;
import com.erp.location.service.LocationService;
import com.etpl.common.util.ResponseObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/p/location/")
@Api(value = "School ERP Location Master Pesistance API", description = "Location Persistance API can be used to create or update Location", tags = {
		"Location Persistance API" })
public class LocationPersistController {
	
	@Autowired
	private LocationService locationService;
	
	/** ########################### Country Information ######################################## */

	@ApiOperation(value = "Create a New Country" ,response = ResponseObject.class)
	@PostMapping(value = "new/country/")
	public ResponseEntity<Countries> newCountry(@RequestBody Countries reqObj) {
		Countries resObj = locationService.newCountry(reqObj);
		return new ResponseEntity<Countries>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing Country information",response = ResponseObject.class)
	@PostMapping(value = "update/countries/")
	public ResponseEntity<?> updateCountry(@RequestBody Countries reqObj) {
		locationService.updateCountries(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Country Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### State Information ######################################## */

	@ApiOperation(value = "Create a New States" ,response = ResponseObject.class)
	@PostMapping(value = "new/state/")
	public ResponseEntity<States> newState(@RequestBody States reqObj) {
		States resObj = locationService.newState(reqObj);
		return new ResponseEntity<States>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing States information",response = ResponseObject.class)
	@PostMapping(value = "update/states/")
	public ResponseEntity<?> updateSates(@RequestBody States reqObj) {
		locationService.updateStates(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("State Details Updated Successfully"),
				HttpStatus.OK);
	}
	
	/** ########################### Cities Information ######################################## */

	@ApiOperation(value = "Create a New Cities" ,response = ResponseObject.class)
	@PostMapping(value = "new/cities/")
	public ResponseEntity<Cities> newState(@RequestBody Cities reqObj) {
		Cities resObj = locationService.newCities(reqObj);
		return new ResponseEntity<Cities>(resObj, HttpStatus.OK);
	}

	@ApiOperation(value = "Revise or Amend existing States information",response = ResponseObject.class)
	@PostMapping(value = "update/cities/")
	public ResponseEntity<?> updateCities(@RequestBody Cities reqObj) {
		locationService.updateCities(reqObj);
		return new ResponseEntity<ResponseObject>(new ResponseObject("Cities Details Updated Successfully"),
				HttpStatus.OK);
	}
	
}
