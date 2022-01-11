package com.springboot.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class SaleListNotFoundException extends RuntimeException{

	public SaleListNotFoundException() {super();}
	
	public  SaleListNotFoundException(String message) {
		super(message);
	}

}
