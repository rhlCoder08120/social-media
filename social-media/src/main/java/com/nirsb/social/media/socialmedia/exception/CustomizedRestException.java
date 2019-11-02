package com.nirsb.social.media.socialmedia.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedRestException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllCustomException(Exception ex, WebRequest request) {
		 ExceptionRespnse exceptionRespnse = new ExceptionRespnse(new Date(), ex.getMessage(), "FAILED", request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionRespnse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionRespnse exceptionRespnse = new ExceptionRespnse(new Date(), ex.getBindingResult().getFieldError().getDefaultMessage().toString(), "FAILED", request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionRespnse,HttpStatus.BAD_REQUEST);
	}
	
}
