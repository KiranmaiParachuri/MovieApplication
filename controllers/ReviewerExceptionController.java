package com.example.springdatajpa.learnspringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.ReviewerNotFoundException;

@ControllerAdvice
public class ReviewerExceptionController {

	@ExceptionHandler(value = EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {

		return new ResponseEntity<>("Input Feilds are empty", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ReviewerNotFoundException.class)
	public ResponseEntity<Object> exception(ReviewerNotFoundException exception) {

		return new ResponseEntity<>("Response not found", HttpStatus.NOT_FOUND);
	}
}
