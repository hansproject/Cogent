package com.springboot.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ContainerNotFoundException extends RuntimeException{

	public ContainerNotFoundException() {super();}
	
	public  ContainerNotFoundException(String message) {
		super(message);
	}

}
