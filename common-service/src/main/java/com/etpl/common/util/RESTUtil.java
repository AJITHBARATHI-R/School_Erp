package com.etpl.common.util;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import com.etpl.common.exception.BadRequestException;
import com.etpl.common.exception.RecordNotFoundException;

public interface RESTUtil {

	public static String RequestBody(String reqParam, String module) {
		try {
			Optional.of(reqParam).orElseThrow(() -> new BadRequestException(module));
		} catch (Exception e) {throw new BadRequestException(module);}
		return reqParam;
	}
	
	
	public static long RequestBody(long reqParam, String module) {
		try {
			if(0==reqParam)	throw new BadRequestException(module);
		} catch (Exception e) {	throw new BadRequestException(module);}
		return reqParam;
	}
	
	public static double RequestBody(double reqParam, String module) {
		try {
			if(0==reqParam)	throw new BadRequestException(module);
		} catch (Exception e) {	throw new BadRequestException(module);}
		return reqParam;
	}

	public static int RequestBody(int reqParam, String module) {
		try {
			if(0==reqParam)	throw new BadRequestException(module);
		} catch (Exception e) {	throw new BadRequestException(module);}
		return reqParam;
	}
	
	public static ResponseEntity<List<?>> ResponseEntity(List<?> resultList, String module) {
		try {
			if (CollectionUtils.isEmpty(resultList))throw new RecordNotFoundException(module);
		} catch (Exception e) {	throw new RecordNotFoundException(module);		}
		return new ResponseEntity<List<?>>(resultList, HttpStatus.OK);
	}

	public static List<?> ResponseEntityList(List<?> resultList, String module) {
		try {
			if (CollectionUtils.isEmpty(resultList))throw new RecordNotFoundException(module);
		} catch (Exception e) {	throw new RecordNotFoundException(module);		}
		return resultList;
	}

}
