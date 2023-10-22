package com.engineerpro.exercise.week1.dto.request;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class AddMovieRequestDto {

    @NotNull(message = "Movie id must not be null")
    private Long movieId;

}
