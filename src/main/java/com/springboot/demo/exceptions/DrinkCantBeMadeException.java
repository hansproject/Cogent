package com.springboot.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DrinkCantBeMadeException extends RuntimeException{

	public DrinkCantBeMadeException() {super();}
	
	public  DrinkCantBeMadeException(String message) {
		super(message);
	}

}
