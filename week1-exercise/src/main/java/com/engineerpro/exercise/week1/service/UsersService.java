package com.engineerpro.exercise.week1.service;

import java.util.List;

import com.engineerpro.exercise.week1.model.Movies;

public interface UsersService {
    void addMovie(Long userId, Long movieId) throws Exception;
    void removeMovie(Long userId, Long movieId) throws Exception;
    List<Movies> findAllMovies(Long userId) throws Exception;
}