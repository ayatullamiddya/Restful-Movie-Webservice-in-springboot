package com.am.restfullapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.am.restfullapi.exception.MovieNotFoundException;
import com.am.restfullapi.exception.MoviesListEmptyException;
import com.am.restfullapi.model.Movie;
import com.am.restfullapi.service.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private IMovieService IMovieService;
	
	@GetMapping("/")
	public List<Movie> getAllMovies() throws MoviesListEmptyException{
		return IMovieService.findAllMovies();
		
	}
	
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") String id) throws MovieNotFoundException {
		System.out.println(id);
		return IMovieService.findMovieById(id);
		
	}
	
	@PostMapping("/")
	public Movie postMovie(@RequestBody Movie movie) throws MovieNotFoundException {
		System.out.println(movie);
		 IMovieService.saveMovie(movie);
		 return movie;
		
	}
	
	@PutMapping("/")
	public Movie updateMovie(@RequestBody Movie movie) throws MovieNotFoundException {
		IMovieService.updateMovie(movie);
		 return movie;
		
	}
	
	@DeleteMapping("/{id}")
	public Movie deleteMovie(@PathVariable("id") String id) throws MovieNotFoundException {
		return IMovieService.deleteMovie(id);
		
	}
}
