package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpa.learnspringdatajpa.entity.ReviewerEntity;

public interface ReviewerRepository extends CrudRepository<ReviewerEntity, Integer>{

}
