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
@Table(name = "genres")
public class GenresEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gen_id")
	private Integer genId;

	@Column(name = "gen_title")
	private String genTitle;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="genmov",referencedColumnName = "gen_id")
	private List<MovieGenresEntity> movieGenresEntity =new ArrayList<>();
	
	public GenresEntity() {
		
	}

	public GenresEntity(String genTitle) {
		super();
		this.genTitle = genTitle;
	}

	public Integer getGenId() {
		return genId;
	}

	public void setGenId(Integer genId) {
		this.genId = genId;
	}

	public String getGenTitle() {
		return genTitle;
	}

	public void setGenTitle(String genTitle) {
		this.genTitle = genTitle;
	}

	public List<MovieGenresEntity> getMovieGenresEntity() {
		return movieGenresEntity;
	}

	public void setMovieGenresEntity(List<MovieGenresEntity> movieGenresEntity) {
		this.movieGenresEntity = movieGenresEntity;
	}
	

}
