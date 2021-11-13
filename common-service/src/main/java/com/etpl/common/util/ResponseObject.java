package com.etpl.common.util;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	/*
	 * public String getMessage() { return message; }
	 * 
	 * public void setMessage(String message) { this.message = message; }
	 */
	
	
	
	

}
