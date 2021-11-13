package com.etpl.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {super("ER_404");	}

	public RecordNotFoundException(String module){super(module+": " +ETPLErrorCode.ER_404);	}
}
