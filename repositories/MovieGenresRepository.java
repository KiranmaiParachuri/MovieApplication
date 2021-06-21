package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpa.learnspringdatajpa.entity.MovieGenresEntity;

public interface MovieGenresRepository extends CrudRepository<MovieGenresEntity, Integer> {

}
