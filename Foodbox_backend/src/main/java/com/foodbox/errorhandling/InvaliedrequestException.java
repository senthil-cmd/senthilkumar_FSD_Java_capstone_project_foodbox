package com.foodbox.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InvaliedrequestException extends RuntimeException{

	public InvaliedrequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
