package com.am.restfullapi.service;

import java.util.List;

import com.am.restfullapi.exception.MovieNotFoundException;
import com.am.restfullapi.exception.MoviesListEmptyException;
import com.am.restfullapi.model.Movie;


public interface IMovieService {
	public String saveMovie(Movie movie);
	public List<Movie> findAllMovies() throws MoviesListEmptyException;
	public Movie findMovieById(String id) throws MovieNotFoundException;
	public Movie updateMovie(Movie movie) throws MovieNotFoundException;
	public Movie deleteMovie(String id) throws MovieNotFoundException;
}
