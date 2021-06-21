package com.example.springdatajpa.learnspringdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_genres")
public class MovieGenresEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mov_id")
	private Integer movId;

	@Column(name = "gen_id")
	private Integer genId;
	
	public MovieGenresEntity() {
		
	}

	public MovieGenresEntity(Integer genId) {
		super();
		this.genId = genId;
	}

	public Integer getMovId() {
		return movId;
	}

	public void setMovId(Integer movId) {
		this.movId = movId;
	}

	public Integer getGenId() {
		return genId;
	}

	public void setGenId(Integer genId) {
		this.genId = genId;
	}

	
}
