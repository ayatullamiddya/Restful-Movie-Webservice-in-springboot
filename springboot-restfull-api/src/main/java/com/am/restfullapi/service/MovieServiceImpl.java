package com.am.restfullapi.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.restfullapi.exception.MovieNotFoundException;
import com.am.restfullapi.exception.MoviesListEmptyException;
import com.am.restfullapi.model.Movie;
import com.am.restfullapi.repository.MovieRepository;

@Service
public class MovieServiceImpl implements IMovieService{
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public String saveMovie(Movie movie) {
		String id = movie.getMovieName().substring(0, 3).toUpperCase() + movie.getReleaseDate();
		movie.setId(id);
		return movieRepository.save(movie).getId();
	}

	@Override
	public List<Movie> findAllMovies() throws MoviesListEmptyException {
		List<Movie> list  = movieRepository.findAll();
		if(list.size() == 0) {
			throw new MoviesListEmptyException("database is empty");
		}
		return list ;
	}

	@Override
	public Movie findMovieById(String id) throws MovieNotFoundException {
		Optional<Movie> movie = movieRepository.findById(id);
		if(movie.isPresent()) {
			throw new MovieNotFoundException("not found data with id "+ id);
		}
		return movie.get();
	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieNotFoundException {
		Movie movie1 = findMovieById(movie.getId());
		movieRepository.deleteById(movie.getId());
		saveMovie(movie);
		return movie;
	}

	@Override
	public Movie deleteMovie(String id) throws MovieNotFoundException {
		Movie movie = findMovieById(id);
		movieRepository.deleteById(id);
		return movie;
	}

}
