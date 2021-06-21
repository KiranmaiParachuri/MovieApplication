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

import com.example.springdatajpa.learnspringdatajpa.entity.GenresEntity;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.GenresNotFoundException;
import com.example.springdatajpa.learnspringdatajpa.services.GenresService;

@RestController
@RequestMapping(value = "/genres")
public class GenresController {

	@Autowired
	private GenresService genresService;

	@GetMapping
	public List<GenresEntity> getGenres() {
		return genresService.getAllGenres();
	}

	@PostMapping
	private ResponseEntity<Object> updateGenres(@RequestBody GenresEntity genresEntity) {

		if (genresEntity.getGenTitle().length() == 0) {

			throw new EmptyInputException();
		} else {

			genresService.updateGenres(genresEntity);
			return new ResponseEntity<>("Genres is created Sucessfully with id: " + genresEntity.getGenId(),
					HttpStatus.CREATED);

		}
	}

	@RequestMapping("/{genId}")
	private ResponseEntity<Object> getGenres(@PathVariable(name = "genId") Integer genId) {

		Boolean isGenresExit = genresService.isGenresExit(genId);
		if (isGenresExit) {

			GenresEntity genresEntity = genresService.getGenresById(genId);
			return new ResponseEntity<Object>(genresEntity, HttpStatus.OK);
		} else {

			throw new GenresNotFoundException();
		}
	}

	@PutMapping("/{genId}")

	private ResponseEntity<Object> update(@PathVariable(name = "genId") Integer genId,
			@RequestBody GenresEntity genresEntity) {

		Boolean isGenresExit = genresService.isGenresExit(genId);
		if (isGenresExit) {

			genresService.update(genId, genresEntity);
			return new ResponseEntity<>("Item will be updated", HttpStatus.OK);

		} else {

			throw new GenresNotFoundException();
		}
	}

	@DeleteMapping("/{genId}")
	private ResponseEntity<Object> deleteGenres(@PathVariable("genId") Integer genId) {

		Boolean isGenresExit = genresService.isGenresExit(genId);
		if (isGenresExit) {

			genresService.delete(genId);
			return new ResponseEntity<>("Item will be deleted", HttpStatus.OK);

		} else {

			throw new GenresNotFoundException();
		}
	}
}
