package com.am.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.am.restfullapi.model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie,String>{

}
