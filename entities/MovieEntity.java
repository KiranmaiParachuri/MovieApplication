package com.example.springdatajpa.learnspringdatajpa.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "movie")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mov_id")
	private Integer movId;

	@Column(name = "mov_title")
	private String movtitle;

	@Column(name = "mov_year")
	private Integer movYear;

	@Column(name = "mov_time")
	private Integer movtime;

	@Column(name = "mov_lang")
	private String movLang;

	@Column(name = "mov_dt_rel")
	private Date movDtRel;

	@Column(name = "mov_rel_country")
	private String movRelCountry;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="movdirfk",referencedColumnName = "mov_id")
	List<MovieDirectionEntity> movieDirectionEntity=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="movcastfk",referencedColumnName = "mov_id")
	List<MovieCastEntity> movieCastEntity=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ratfk",referencedColumnName = "mov_id")
	List<RatingEntity> ratingEntity=new ArrayList<>();
	
	public MovieEntity() {
		
	}

	public MovieEntity(String movtitle, Integer movYear, Integer movtime, String movLang, Date movDtRel,
			String movRelCountry) {
		super();
		this.movtitle = movtitle;
		this.movYear = movYear;
		this.movtime = movtime;
		this.movLang = movLang;
		this.movDtRel = movDtRel;
		this.movRelCountry = movRelCountry;
	}

	public Integer getMovId() {
		return movId;
	}

	public void setMovId(Integer movId) {
		this.movId = movId;
	}

	public String getMovtitle() {
		return movtitle;
	}

	public void setMovtitle(String movtitle) {
		this.movtitle = movtitle;
	}

	public Integer getMovYear() {
		return movYear;
	}

	public void setMovYear(Integer movYear) {
		this.movYear = movYear;
	}

	public Integer getMovtime() {
		return movtime;
	}

	public void setMovtime(Integer movtime) {
		this.movtime = movtime;
	}

	public String getMovLang() {
		return movLang;
	}

	public void setMovLang(String movLang) {
		this.movLang = movLang;
	}

	public Date getMovDtRel() {
		return movDtRel;
	}

	public void setMovDtRel(Date movDtRel) {
		this.movDtRel = movDtRel;
	}

	public String getMovRelCountry() {
		return movRelCountry;
	}

	public void setMovRelCountry(String movRelCountry) {
		this.movRelCountry = movRelCountry;
	}

	public List<MovieDirectionEntity> getMovieDirectionEntity() {
		return movieDirectionEntity;
	}

	public void setMovieDirectionEntity(List<MovieDirectionEntity> movieDirectionEntity) {
		this.movieDirectionEntity = movieDirectionEntity;
	}

	public List<MovieCastEntity> getMovieCastEntity() {
		return movieCastEntity;
	}

	public void setMovieCastEntity(List<MovieCastEntity> movieCastEntity) {
		this.movieCastEntity = movieCastEntity;
	}

	public List<RatingEntity> getRatingEntity() {
		return ratingEntity;
	}

	public void setRatingEntity(List<RatingEntity> ratingEntity) {
		this.ratingEntity = ratingEntity;
	}
	
	
}
