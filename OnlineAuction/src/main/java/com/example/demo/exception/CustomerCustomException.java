package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerCustomException extends RuntimeException{

public static final long serialVersionUID = 1L;
	
	public CustomerCustomException(String message) {
		super(message);
	}
}
