package com.example.springdatajpa.learnspringdatajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.learnspringdatajpa.entity.ReviewerEntity;
import com.example.springdatajpa.learnspringdatajpa.repositories.ReviewerRepository;

@Service
public class ReviewerService {

	@Autowired
	private ReviewerRepository reviewerRepository;
	
	public List<ReviewerEntity> getAllReviewers() {
		return (List<ReviewerEntity>) reviewerRepository.findAll();
	}

	public ReviewerEntity updateReviewer(ReviewerEntity reviewerEntity) {

		return reviewerRepository.save(reviewerEntity);

	}

	public ReviewerEntity getReviewerById(Integer revId) {
		return reviewerRepository.findById(revId).get();
	}

	public void update(Integer revId, ReviewerEntity reviewerEntity) {
		reviewerRepository.save(reviewerEntity);
	}

	public void delete(Integer revId) {
		reviewerRepository.deleteById(revId);
	}

	public Boolean isReviewerExit(Integer revId) {
		
		return reviewerRepository.existsById(revId);
	}
	
}
