package com.engineerpro.exercise.week1.repository;

import org.springframework.data.repository.CrudRepository;
import com.engineerpro.exercise.week1.model.Movies;


public interface MoviesRepo extends CrudRepository<Movies, Long> {

  Movies findById(long id);

}