package com.example.springdatajpa.learnspringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springdatajpa.learnspringdatajpa.exceptions.DirectorNotFoundException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;

@ControllerAdvice
public class DirectorExceptionController {

	@ExceptionHandler(value=EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {

		return new ResponseEntity<>("Input Feilds are empty", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=DirectorNotFoundException.class)
	public ResponseEntity<Object> exception(DirectorNotFoundException exception) {

		return new ResponseEntity<>("Director not found", HttpStatus.NOT_FOUND);
	}

	
}
