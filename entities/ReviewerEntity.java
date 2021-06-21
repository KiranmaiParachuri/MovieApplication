package com.example.springdatajpa.learnspringdatajpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reviewer")
public class ReviewerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rev_id")
	private Integer revId;

	@Column(name = "rev_name")
	private String revName;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="revrat",referencedColumnName = "rev_id")
	private List<RatingEntity> ratingEntity =new ArrayList<>();
	
	public ReviewerEntity() {
		
	}

	public ReviewerEntity(String revName) {
		super();
		this.revName = revName;
	}

	public Integer getRevId() {
		return revId;
	}

	public void setRevId(Integer revId) {
		this.revId = revId;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public List<RatingEntity> getRatingEntity() {
		return ratingEntity;
	}

	public void setRatingEntity(List<RatingEntity> ratingEntity) {
		this.ratingEntity = ratingEntity;
	}
	
	
	
}
