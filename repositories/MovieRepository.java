package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.learnspringdatajpa.entity.MovieEntity;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {

}
