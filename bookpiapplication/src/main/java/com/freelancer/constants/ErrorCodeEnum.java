package com.freelancer.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ErrorCodeEnum {

    BOOK_NOT_FOUND(1001, "Book Not Found"),
	BOOK_NOT_FOUND_TO_DELETE(1002,"Sorry Book Not Found"),
	
	INTERNAL_SERVER_ERROR(1003,"An unexpected error occurred:");
	

    private final int errorCode;
    private final String errorMessage;
}

