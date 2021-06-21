package com.example.springdatajpa.learnspringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.GenresNotFoundException;

@ControllerAdvice
public class GenresExceptionController {

	@ExceptionHandler(value=EmptyInputException.class)
	public ResponseEntity<Object> emptyInputs(EmptyInputException emptyInputException){
		
		return new ResponseEntity<Object>("Input Feilds are Empty",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=GenresNotFoundException.class)
	public ResponseEntity<Object> exception(GenresNotFoundException genresNotFoundException){
		
		return new ResponseEntity<Object>("Item Not Found",HttpStatus.NOT_FOUND);
	}
}
