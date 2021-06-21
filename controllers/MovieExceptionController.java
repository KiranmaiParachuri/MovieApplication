package com.example.springdatajpa.learnspringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.MovieNotFoundException;


@ControllerAdvice
public class MovieExceptionController {

	@ExceptionHandler(value = EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {

		return new ResponseEntity<>("Input Feilds are empty", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MovieNotFoundException.class)
	public ResponseEntity<Object> exception(MovieNotFoundException exception) {

		return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
	}

}
