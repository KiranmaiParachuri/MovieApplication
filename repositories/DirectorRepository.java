package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.learnspringdatajpa.entity.DirectorEntity;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorEntity, Integer> {

}
