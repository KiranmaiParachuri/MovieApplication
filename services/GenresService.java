package com.example.springdatajpa.learnspringdatajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.learnspringdatajpa.entity.GenresEntity;
import com.example.springdatajpa.learnspringdatajpa.repositories.GenresRepository;


@Service
public class GenresService {

	@Autowired
	private GenresRepository genresRepository;
	
	public List<GenresEntity> getAllGenres() {
		return (List<GenresEntity>) genresRepository.findAll();
	}

	public GenresEntity updateGenres(GenresEntity genresEntity) {

		return genresRepository.save(genresEntity);

	}

	public GenresEntity getGenresById(Integer genId) {
		return genresRepository.findById(genId).get();
	}

	public void update(Integer genId, GenresEntity genresEntity) {
		genresRepository.save(genresEntity);
	}

	public void delete(Integer genId) {
		genresRepository.deleteById(genId);
	}

	public Boolean isGenresExit(Integer genId) {
	
		return genresRepository.existsById(genId);
	}
	
}
