package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpa.learnspringdatajpa.entity.GenresEntity;

public interface GenresRepository  extends CrudRepository<GenresEntity, Integer>{

}
