package com.am.restfullapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	private String id;
	private String movieName;
	private String releaseDate;
	private String cast;
}
