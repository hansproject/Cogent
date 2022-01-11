package com.springboot.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RefillNotFoundException extends RuntimeException{

	public RefillNotFoundException() {super();}
	
	public  RefillNotFoundException(String message) {
		super(message);
	}

}
