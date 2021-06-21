package com.example.springdatajpa.learnspringdatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.learnspringdatajpa.entity.MovieEntity;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.MovieNotFoundException;
import com.example.springdatajpa.learnspringdatajpa.services.MovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<MovieEntity> getMovie() {
		return movieService.getAllMovies();
	}

	@PostMapping
	private ResponseEntity<Object> updateMovie(@RequestBody MovieEntity movieEntity) {

		if (movieEntity.getMovtitle().isEmpty()) {

			throw new EmptyInputException();

		} else {

			movieService.updateMovie(movieEntity);
			return new ResponseEntity<Object>("Movie is created sucessfully with Id: " + movieEntity.getMovId(),
					HttpStatus.OK);
		}
	}

	@RequestMapping("/{movId}")
	private ResponseEntity<Object> getMovie(@PathVariable(name = "movId") Integer movId) {

		Boolean isMovieExit = movieService.isMovieExit(movId);
		if (isMovieExit) {

			MovieEntity movieEntity = movieService.getMovieById(movId);
			return new ResponseEntity<>(movieEntity, HttpStatus.OK);
		} else {
			throw new MovieNotFoundException();
		}

	}

	@PutMapping("/{movId}")

	private ResponseEntity<Object> update(@PathVariable(name = "movId") Integer movId,
			@RequestBody MovieEntity movieEntity) {

		Boolean isMovieExit = movieService.isMovieExit(movId);
		if (isMovieExit) {

			movieService.update(movId, movieEntity);
			return new ResponseEntity<>("Movie will be updated", HttpStatus.OK);
		} else {

			throw new MovieNotFoundException();
		}
	}

	@DeleteMapping("/{movId}")
	private ResponseEntity<Object> deleteMovie(@PathVariable("movId") Integer movId) {

		Boolean isMovieExit = movieService.isMovieExit(movId);
		if (isMovieExit) {

			movieService.delete(movId);
			return new ResponseEntity<>("Movie will be deleted", HttpStatus.OK);
		} else {
			throw new MovieNotFoundException();
		}
	}
}
