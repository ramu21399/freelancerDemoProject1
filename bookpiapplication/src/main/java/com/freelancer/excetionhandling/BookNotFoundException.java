package com.freelancer.excetionhandling;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMessage;
	private HttpStatus httpStatus;

}
