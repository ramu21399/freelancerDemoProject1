package com.freelancer.excetionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.freelancer.constants.ErrorCodeEnum;
import com.freelancer.dto.ErrorResponse;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;

@Hidden
@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorResponse> bookNotFoundException(BookNotFoundException ex, HttpServletRequest request) {

		ErrorResponse errorResponse = ErrorResponse.builder().errorCode(ex.getErrorCode())
				.errorMessage(ex.getErrorMessage()).build();

		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse>handleGeneralExcetion(Exception ex){
		
		ErrorResponse errorres= ErrorResponse.builder()
				.errorCode(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getErrorCode())
				.errorMessage(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getErrorMessage())
				.build();
		
		return new ResponseEntity<ErrorResponse>(errorres, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
