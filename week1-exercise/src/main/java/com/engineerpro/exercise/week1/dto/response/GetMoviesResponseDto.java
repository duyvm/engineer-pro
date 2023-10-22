package com.engineerpro.exercise.week1.dto.response;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import com.engineerpro.exercise.week1.model.Movies;

public class GetMoviesResponseDto extends GeneralResponseDto {
    @NotNull
    private List<MovieDto> movies;

    public void setMovies(List<Movies> movies) {
        this.movies = movies.stream()
            .map(movie -> new MovieDto(movie.getId(), movie.getTitle()))
            .collect(Collectors.toList());
    }
}