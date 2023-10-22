package com.engineerpro.exercise.week1.service;

import java.util.List;

import com.engineerpro.exercise.week1.exception.MovieNotFoundException;
import com.engineerpro.exercise.week1.exception.UserNotFoundException;
import com.engineerpro.exercise.week1.model.Movies;

public interface UsersService {
    void addMovie(Long userId, Long movieId) throws UserNotFoundException, MovieNotFoundException;
    void removeMovie(Long userId, Long movieId) throws UserNotFoundException, MovieNotFoundException;
    List<Movies> findAllMovies(Long userId) throws UserNotFoundException;
}