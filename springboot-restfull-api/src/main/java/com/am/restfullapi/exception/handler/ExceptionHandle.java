package com.am.restfullapi.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.am.restfullapi.exception.MovieNotFoundException;
import com.am.restfullapi.exception.MoviesListEmptyException;

@RestControllerAdvice
public class ExceptionHandle {
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<?> handleMovieNotFoundException(MovieNotFoundException ex) {
		
		return new ResponseEntity<String>(new String(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MoviesListEmptyException.class)
	public ResponseEntity<?> handleMoviesListEmptyException(MoviesListEmptyException ex) {
		
		return new ResponseEntity<String>(new String(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
