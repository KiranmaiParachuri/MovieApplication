package com.example.springdatajpa.learnspringdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "moviedirection")
public class MovieDirectionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dir_id")
	private Integer dirId;

	@Column(name = "mov_id")
	private Integer movId;
	
	public MovieDirectionEntity() {
		
	}

	public MovieDirectionEntity(Integer movId) {
		super();
		this.movId = movId;
	}

	public Integer getDirId() {
		return dirId;
	}

	public void setDirId(Integer dirId) {
		this.dirId = dirId;
	}

	public Integer getMovId() {
		return movId;
	}

	public void setMovId(Integer movId) {
		this.movId = movId;
	}
	
	
}
