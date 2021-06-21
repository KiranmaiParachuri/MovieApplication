package com.example.springdatajpa.learnspringdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class RatingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mov_id")
	private Integer movId;

	@Column(name = "rev_id")
	private Integer revId;

	@Column(name = "rev_stars")
	private Integer revStars;

	@Column(name = "no_of_ratings")
	private Integer noOfRatings;
	
	public RatingEntity() {
		
	}

	public RatingEntity(Integer revId, Integer revStars, Integer noOfRatings) {
		super();
		this.revId = revId;
		this.revStars = revStars;
		this.noOfRatings = noOfRatings;
	}

	public Integer getMovId() {
		return movId;
	}

	public void setMovId(Integer movId) {
		this.movId = movId;
	}

	public Integer getRevId() {
		return revId;
	}

	public void setRevId(Integer revId) {
		this.revId = revId;
	}

	public Integer getRevStars() {
		return revStars;
	}

	public void setRevStars(Integer revStars) {
		this.revStars = revStars;
	}

	public Integer getNoOfRatings() {
		return noOfRatings;
	}

	public void setNoOfRatings(Integer noOfRatings) {
		this.noOfRatings = noOfRatings;
	}
	
	
}
