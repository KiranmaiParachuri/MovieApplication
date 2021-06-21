package com.example.springdatajpa.learnspringdatajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.learnspringdatajpa.entity.ActorEntity;
import com.example.springdatajpa.learnspringdatajpa.repositories.ActorRepository;

@Service
public class ActorService {
	@Autowired
	private ActorRepository acRepository;

	public List<ActorEntity> getAllActors() {
		
		return (List<ActorEntity>) acRepository.findAll();
	}

	public ActorEntity updateActor(ActorEntity actorEntity) {

		
		return acRepository.save(actorEntity);

	}

	public ActorEntity getActorById(Integer actId) {
		
		return acRepository.findById(actId).get();
	}

	public void update(Integer actId, ActorEntity actorEntity) {
		
		acRepository.save(actorEntity);
	}

	public void delete(Integer actId) {
		
		acRepository.deleteById(actId);
	}

	public  Boolean isActorExit(Integer actId) {
		
		return acRepository.existsById(actId);
	}
	
	

}
