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

import com.example.springdatajpa.learnspringdatajpa.entity.ReviewerEntity;
import com.example.springdatajpa.learnspringdatajpa.exceptions.EmptyInputException;
import com.example.springdatajpa.learnspringdatajpa.exceptions.ReviewerNotFoundException;
import com.example.springdatajpa.learnspringdatajpa.services.ReviewerService;

@RestController
@RequestMapping(value = "reviewer")
public class ReviewerController {

	@Autowired
	private ReviewerService reviewerService;

	@GetMapping
	public List<ReviewerEntity> getReviewers() {
		return reviewerService.getAllReviewers();
	}

	@PostMapping
	private ResponseEntity<Object> updateReviewers(@RequestBody ReviewerEntity reviewerEntity) {

		if (reviewerEntity.getRevName().isEmpty()) {
			
			throw new EmptyInputException();
			
		} else {
			
			reviewerService.updateReviewer(reviewerEntity);
			return new ResponseEntity<>("Response is created sucessfully with Id: " + reviewerEntity.getRevId(),
					HttpStatus.OK);
		}

	}

	@RequestMapping("/{revId}")
	private ResponseEntity<Object> getReviewers(@PathVariable(name = "revId") Integer revId) {

		Boolean isReviewerExit = reviewerService.isReviewerExit(revId);
		if (isReviewerExit) {

			ReviewerEntity reviewerEntity = reviewerService.getReviewerById(revId);
			return new ResponseEntity<>(reviewerEntity, HttpStatus.OK);

		} else {

			throw new ReviewerNotFoundException();
		}
	}

	@PutMapping("/{revId}")

	private ResponseEntity<Object> update(@PathVariable(name = "revId") Integer revId,
			@RequestBody ReviewerEntity reviewerEntity) {

		Boolean isReviewerExit = reviewerService.isReviewerExit(revId);
		if (isReviewerExit) {

			reviewerService.update(revId, reviewerEntity);
			return new ResponseEntity<>("Response will be updated", HttpStatus.OK);

		} else {

			throw new ReviewerNotFoundException();
		}
	}

	@DeleteMapping("/{revId}")
	private ResponseEntity<Object> delete(@PathVariable("revId") Integer revId) {

		Boolean isReviewerExit = reviewerService.isReviewerExit(revId);
		if (isReviewerExit) {

			reviewerService.delete(revId);
			return new ResponseEntity<>("Response will be deleted", HttpStatus.OK);

		} else {

			throw new ReviewerNotFoundException();
		}
	}
}
