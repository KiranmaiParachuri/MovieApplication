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

import com.example.springdatajpa.learnspringdatajpa.entity.DirectorEntity;
import com.example.springdatajpa.learnspringdatajpa.exceptions.DirectorNotFoundException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.services.DirectorService;

@RestController
@RequestMapping("/directors")
public class DirectorController {

	@Autowired
	private DirectorService directorService;

	@GetMapping
	public List<DirectorEntity> getDirectors() {
		return directorService.getAllDirectors();
	}

	@PostMapping
	private ResponseEntity<Object> updateDirector(@RequestBody DirectorEntity directorEntity) {

		if (directorEntity.getDirFName().isEmpty() || directorEntity.getDirLName().isEmpty()) {
			throw new EmptyInputException();
		} else {

			directorService.updateDirector(directorEntity);
			return new ResponseEntity<>("Director is created Successfully with Id: " + directorEntity.getDirId(),
					HttpStatus.CREATED);
		}

	}

	@RequestMapping("/{dirId}")
	private ResponseEntity<Object> getDirector(@PathVariable(name = "dirId") Integer dirId) {

		Boolean isDirectorExit = directorService.isDirectorExit(dirId);
		if (isDirectorExit) {

			DirectorEntity directorEntity = directorService.getDirectorById(dirId);
			return new ResponseEntity<Object>(directorEntity, HttpStatus.OK);

		} else {

			throw new DirectorNotFoundException();
		}

	}

	@PutMapping("/{dirId}")

	private ResponseEntity<Object> update(@PathVariable(name = "dirId") Integer dirId,
			@RequestBody DirectorEntity directorEntity) {

		Boolean isDirectorExit = directorService.isDirectorExit(dirId);
		if (isDirectorExit) {

			directorService.update(dirId, directorEntity);
			return new ResponseEntity<Object>("Director is Updated Sucessfully", HttpStatus.OK);

		} else {
			throw new DirectorNotFoundException();
		}
	}

	@DeleteMapping("/{dirId}")
	private ResponseEntity<Object> deleteDirector(@PathVariable("dirId") Integer dirId) {

		Boolean isDirectorExit = directorService.isDirectorExit(dirId);
		if (isDirectorExit) {

			directorService.delete(dirId);
			return new ResponseEntity<Object>("Director is deleted Sucessfully", HttpStatus.OK);
		} else {

			throw new DirectorNotFoundException();
		}
	}
}
