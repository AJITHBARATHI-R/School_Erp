package com.etpl.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateDataException(String message) {
		super(message);
	}
}
