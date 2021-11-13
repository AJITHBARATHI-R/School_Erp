

package com.etpl.common.exception;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ETPLCustomizedExceptionHandling  extends ResponseEntityExceptionHandler{

	
	  // error handle for @Valid
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handlerExceptionResolver(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionEntity> handleExceptions(BadRequestException ex, WebRequest request) {
		ExceptionEntity error = new ExceptionEntity();
		error.setStatus("400");
		error.setMessage(ex.getMessage());
		error.setMessage("Invalid fields requested:One or multiple field in the list of field you are passing is invalid-Verify that the fields you are passing are valid");
		error.setTimestamp(new Date());
		error.setDescription(ex.getStackTrace().toString());
		return new ResponseEntity<ExceptionEntity>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ExceptionEntity> handleExceptions(RecordNotFoundException ex, WebRequest request) {
		ExceptionEntity error = new ExceptionEntity();
		error.setStatus("404");
		error.setTimestamp(new Date());
		error.setMessage(ex.getMessage());
		error.setDescription(ex.getStackTrace().toString());
		return new ResponseEntity<ExceptionEntity>(error, HttpStatus.NOT_FOUND);
	}
	/*
	 * @ExceptionHandler(DuplicateDataException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.CONFLICT) public
	 * ResponseEntity<ExceptionEntity> handleDuplicateDataException(Exception ex,
	 * WebRequest request) { ExceptionEntity error = new ExceptionEntity();
	 * error.setCode("failure"); error.setTimestamp(new Date());
	 * error.setMessage(ex.getMessage());
	 * error.setDescription("Data already available try to insert with new data");
	 * return new ResponseEntity<ExceptionEntity>(error, HttpStatus.OK); }
	 * 
	 * @ExceptionHandler(NumberFormatException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public
	 * ResponseEntity<ExceptionEntity> handleNumberFormatException(Exception ex,
	 * WebRequest request) { ExceptionEntity error = new ExceptionEntity();
	 * error.setCode("failure"); error.setTimestamp(new Date());
	 * error.setMessage("Please provide an integer value");
	 * error.setDescription("Passing value is not a number!!"); return new
	 * ResponseEntity<ExceptionEntity>(error, HttpStatus.OK); }
	 * 
	 * @ExceptionHandler(HttpMessageNotReadableException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public
	 * ResponseEntity<ExceptionEntity>
	 * handleHttpMessageNotReadableException(Exception ex, WebRequest request) {
	 * ExceptionEntity error = new ExceptionEntity(); error.setCode("failure");
	 * error.setTimestamp(new Date()); error.setMessage("Invalid Data Found");
	 * error.setDescription("Please enter a valid data"); return new
	 * ResponseEntity<ExceptionEntity>(error, HttpStatus.OK); }
	 * 
	 * @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public
	 * ResponseEntity<ExceptionEntity> handleArrayIndexException(Exception ex,
	 * WebRequest request) {
	 * 
	 * ExceptionEntity error = new ExceptionEntity(); error.setTimestamp(new
	 * Date()); error.setCode("failure"); error.setMessage(ex.getMessage());
	 * error.setDescription("ArrayIndexOutOfBoundsException found!!"); return new
	 * ResponseEntity<ExceptionEntity>(error, HttpStatus.OK); }
	 * 
	 * @ExceptionHandler(IllegalArgumentException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public
	 * ResponseEntity<ExceptionEntity> handleIllegalException(Exception ex,
	 * WebRequest request) {
	 * 
	 * ExceptionEntity error = new ExceptionEntity(); error.setTimestamp(new
	 * Date()); error.setCode("failure"); error.setMessage(ex.getMessage());
	 * error.setDescription("IllegalArgumentException Found!!"); return new
	 * ResponseEntity<ExceptionEntity>(error, HttpStatus.OK); }
	 */
	 

	/*
	 * @ExceptionHandler(DataIntegrityViolationException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.OK) public ResponseEntity<ExceptionEntity>
	 * handleAnyException(Exception ex, WebRequest request) {
	 * 
	 * ExceptionEntity error = new ExceptionEntity(); error.setTimestamp(new
	 * Date()); error.setStatus("failure"); error.
	 * setMessage("The data is already distributed to the secondary level, So you can't delete it"
	 * ); error.setDescription(ex.getMessage()); return new
	 * ResponseEntity<ExceptionEntity>(error, HttpStatus.OK); }
	 */

}
