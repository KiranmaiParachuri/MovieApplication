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
@Table(name = "director")
public class DirectorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dir_id")
	private Integer dirId;

	@Column(name = "dir_fname")
	private String dirFName;

	@Column(name = "dir_lname")
	private String dirLName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dirmov", referencedColumnName = "dir_id")
	private List<MovieDirectionEntity> movieDirectionEntity = new ArrayList<>();

	public DirectorEntity() {

	}

	public DirectorEntity(String dirFName, String dirLName) {
		super();
		this.dirFName = dirFName;
		this.dirLName = dirLName;
	}

	

	public Integer getDirId() {
		return dirId;
	}

	public void setDirId(Integer dirId) {
		this.dirId = dirId;
	}

	public String getDirFName() {
		return dirFName;
	}

	public void setDirFName(String dirFName) {
		this.dirFName = dirFName;
	}

	public String getDirLName() {
		return dirLName;
	}

	public void setDirLName(String dirLName) {
		this.dirLName = dirLName;
	}

	public List<MovieDirectionEntity> getMovieDirectionEntity() {
		return movieDirectionEntity;
	}

	public void setMovieDirectionEntity(List<MovieDirectionEntity> movieDirectionEntity) {
		this.movieDirectionEntity = movieDirectionEntity;
	}

}
