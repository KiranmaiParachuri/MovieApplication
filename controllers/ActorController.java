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

import com.example.springdatajpa.learnspringdatajpa.entity.ActorEntity;
import com.example.springdatajpa.learnspringdatajpa.exceptions.ActorNotfoundException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.services.ActorService;

@RestController
@RequestMapping(value = "/actors")
public class ActorController {

	@Autowired
	private ActorService actorService;

	@GetMapping
	public List<ActorEntity> getActors() {

		return actorService.getAllActors();

	}

	@PostMapping
	private ResponseEntity<Object> updateActor(@RequestBody ActorEntity actorEntity) {

		if (actorEntity.getActFName().isEmpty() || actorEntity.getActLName().isEmpty()
				|| actorEntity.getActGender().isEmpty()) {

			throw new EmptyInputException();
		} else {

			actorService.updateActor(actorEntity);
			return new ResponseEntity<>("Actor is created Successfully with Id: " + actorEntity.getActId(),
					HttpStatus.CREATED);
		}

	}

	@RequestMapping("/{actId}")
	private ResponseEntity<Object> getActors(@PathVariable(name = "actId") Integer actId) {

		Boolean isActorExit = actorService.isActorExit(actId);
		if (isActorExit) {

			ActorEntity actorEntity = actorService.getActorById(actId);
			return new ResponseEntity<Object>(actorEntity, HttpStatus.OK);

		} else {

			throw new ActorNotfoundException();
		}

	}

	@PutMapping("/{actId}")

	private ResponseEntity<Object> update(@PathVariable("actId") Integer actId, @RequestBody ActorEntity actorEntity) {

		Boolean isActorExit = actorService.isActorExit(actId);
		if (isActorExit) {

			actorService.update(actId, actorEntity);
			return new ResponseEntity<>("Actor is Updated successsfully", HttpStatus.OK);

		} else {

			throw new ActorNotfoundException();
		}

	}

	@DeleteMapping("/{actId}")
	private ResponseEntity<Object> deleteActor(@PathVariable("actId") Integer actId) {

		Boolean isActorExit = actorService.isActorExit(actId);
		if (isActorExit) {

			actorService.delete(actId);
			return new ResponseEntity<>("Actor is deleted successsfully", HttpStatus.OK);

		} else {

			throw new ActorNotfoundException();
		}

	}
}
