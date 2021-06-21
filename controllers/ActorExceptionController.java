package com.example.springdatajpa.learnspringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springdatajpa.learnspringdatajpa.exceptions.ActorNotfoundException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;

@ControllerAdvice
public class ActorExceptionController {

	@ExceptionHandler(value = EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {

		return new ResponseEntity<>("Input Feilds are empty", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ActorNotfoundException.class)
	public ResponseEntity<Object> exception(ActorNotfoundException exception) {

		return new ResponseEntity<>("Actor not found", HttpStatus.NOT_FOUND);
	}

}
