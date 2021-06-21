package com.example.springdatajpa.learnspringdatajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.learnspringdatajpa.entity.MovieEntity;
import com.example.springdatajpa.learnspringdatajpa.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<MovieEntity> getAllMovies() {
		return  (List<MovieEntity>) movieRepository.findAll();
	}

	public MovieEntity updateMovie(MovieEntity movieEntity) {

		return movieRepository.save(movieEntity);

	}

	public MovieEntity getMovieById(Integer movId) {
		return movieRepository.findById(movId).get();
	}

	public void update(Integer movId, MovieEntity movieEntity) {
		movieRepository.save(movieEntity);
	}

	public void delete(Integer movId) {
		movieRepository.deleteById(movId);
	}

	public Boolean isMovieExit(Integer movId) {
		
		return movieRepository.existsById(movId);
	}
}
