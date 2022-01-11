package com.springboot.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandlerMapper extends RuntimeException{

	public ExceptionsHandlerMapper() {super();}

	@ExceptionHandler(value = DrinkCantBeMadeException.class)
	public ResponseEntity<Object> handleCourseNotFound(DrinkCantBeMadeException ex) {
		ErrorMapper errorMapper= new ErrorMapper("Drink can't be made", "404", new Date());
		return new ResponseEntity<>(errorMapper, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = RefillNotFoundException.class)
	public ResponseEntity<Object> handleBlogNotFound(RefillNotFoundException ex) {
		ErrorMapper errorMapper= new ErrorMapper("Refill not found", "404", new Date());
		return new ResponseEntity<>(errorMapper, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = SaleListNotFoundException.class)
	public ResponseEntity<Object> handleBlogNotFound(SaleListNotFoundException ex) {
		ErrorMapper errorMapper= new ErrorMapper("SaleList not found", "404", new Date());
		return new ResponseEntity<>(errorMapper, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ContainerNotFoundException.class)
	public ResponseEntity<Object> handleBlogNotFound(ContainerNotFoundException ex) {
		ErrorMapper errorMapper= new ErrorMapper("Container not found", "404", new Date());
		return new ResponseEntity<>(errorMapper, HttpStatus.NOT_FOUND);
	}
}
