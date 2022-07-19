package com.am.restfullapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.am.restfullapi.exception.MoviesListEmptyException;
import com.am.restfullapi.service.IMovieService;

@SpringBootApplication
public class SpringbootRestfullApiApplication {
	@Autowired
	private static IMovieService iMovieService;
	public static void main(String[] args){
		SpringApplication.run(SpringbootRestfullApiApplication.class, args);
		System.out.println(iMovieService);
		
	}
	
	@Autowired
	public void setBean(IMovieService iMovieService) {
		this.iMovieService = iMovieService;
	}
	

}
