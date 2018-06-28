package org.product.controller;

import org.product.exception.BadRequestException;
import org.product.exception.InternalErrorException;

import java.util.Map;

import org.product.exception.*;
import org.product.exception.NotAuthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class BaseController {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundExceptionHandler(NotFoundException ex) {
		//Map<String, String> errors = "loi";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

	 //other exception handlers
	  
//	   @ExceptionHandler(EntityNotFoundException.class)
//	   protected ResponseEntity<Object> handleEntityNotFound(
//	           EntityNotFoundException ex) {
//	       ApiError apiError = new ApiError(NOT_FOUND);
//	       apiError.setMessage(ex.getMessage());
//	       return buildResponseEntity(apiError);
//	   }
//	@ExceptionHandler(value = { Exception.class })
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ApiErrorResponse unknownException(Exception ex, WebRequest req) {
//        return new ApiErrorResponse(...);
//    }
	@ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<?> internalErrorExceptionHandler(InternalErrorException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
	
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(InternalErrorException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
	
	@ExceptionHandler(NotAuthenticatedException.class)
    public ResponseEntity<?> notAuthenticatedExceptionHandler(InternalErrorException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}
