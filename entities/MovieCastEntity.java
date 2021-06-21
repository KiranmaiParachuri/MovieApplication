package com.example.springdatajpa.learnspringdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "moviecast")
public class MovieCastEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private Integer actId;

	@Column(name = "mov_id")
	private Integer movId;

	@Column(name = "role")
	private String role;
	
	public MovieCastEntity() {
		
	}

	public MovieCastEntity(Integer movId, String role) {
		super();
		this.movId = movId;
		this.role = role;
	}

	public Integer getActId() {
		return actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	public Integer getMovId() {
		return movId;
	}

	public void setMovId(Integer movId) {
		this.movId = movId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
