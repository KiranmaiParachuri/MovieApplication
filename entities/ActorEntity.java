
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
@Table(name = "actor")
public class ActorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private Integer actId;

	@Column(name = "act_fname")
	private String actFName;

	@Column(name = "act_lname")
	private String actLName;

	@Column(name = "act_gender")
	private String actGender;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "actmov", referencedColumnName = "act_id")
	List<MovieCastEntity> movieCastEntity = new ArrayList<>();

	public ActorEntity() {

	}

	public ActorEntity(String actFName, String actLName, String actGender) {
		super();
		this.actFName = actFName;
		this.actLName = actLName;
		this.actGender = actGender;
	}

	public Integer getActId() {
		return actId;
	}

	public String getActFName() {
		return actFName;
	}

	public String getActLName() {
		return actLName;
	}

	public String getActGender() {
		return actGender;
	}

	public List<MovieCastEntity> getMovieCastEntity() {
		return movieCastEntity;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	public void setActFName(String actFName) {
		this.actFName = actFName;
	}

	public void setActLName(String actLName) {
		this.actLName = actLName;
	}

	public void setActGender(String actGender) {
		this.actGender = actGender;
	}

	public void setMovieCastEntity(List<MovieCastEntity> movieCastEntity) {
		this.movieCastEntity = movieCastEntity;
	}

}
