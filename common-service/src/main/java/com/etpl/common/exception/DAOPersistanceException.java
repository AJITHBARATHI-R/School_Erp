package com.etpl.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DAOPersistanceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DAOPersistanceException() {
		super(ETPLErrorCode.ER_DAO);
	}

	public DAOPersistanceException(String module) {
		super(module + ": " + ETPLErrorCode.ER_DAO);
	}

	public DAOPersistanceException(Throwable cause) {
		super(ETPLErrorCode.ER_DAO + ": " + cause.getMessage());
	}

	public DAOPersistanceException(String module, Throwable cause) {
		super(module + ": " + ETPLErrorCode.ER_DAO, cause);
	}

}
