package com.etpl.common.exception;

public interface ETPLErrorCode {
	final static String ER_400="Invalid parameters requested: One or multiple parameters in the list of field you are passing is invalid !!";
	final static String ER_404=" Data not found:The parameter passed as part of the request object is not a matching with our record";
	final static String ER_DAO=" Could not persists the data";
}