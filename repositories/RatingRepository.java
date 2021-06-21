package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpa.learnspringdatajpa.entity.RatingEntity;

public interface RatingRepository extends CrudRepository<RatingEntity, Integer> {

}
