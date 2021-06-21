package com.example.springdatajpa.learnspringdatajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.springdatajpa.learnspringdatajpa.entity.DirectorEntity;
import com.example.springdatajpa.learnspringdatajpa.repositories.DirectorRepository;

@Service
public class DirectorService {

	@Autowired
	private DirectorRepository directorRepository;

	public List<DirectorEntity> getAllDirectors() {
		return (List<DirectorEntity>) directorRepository.findAll();
	}

	public DirectorEntity updateDirector(DirectorEntity directorEntity) {

		return directorRepository.save(directorEntity);

	}

	public DirectorEntity getDirectorById(Integer dirId) {
		return directorRepository.findById(dirId).get();
	}

	public void update(Integer dirId, DirectorEntity directorEntity) {
		directorRepository.save(directorEntity);
	}

	public void delete(Integer dirId) {
		directorRepository.deleteById(dirId);
	}

	public Boolean isDirectorExit(Integer dirId) {

		return directorRepository.existsById(dirId);
	}

}
