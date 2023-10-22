package com.engineerpro.exercise.week1.dto.response;

import lombok.Data;

@Data
public class MovieDto {
    private long id;
    private String title;

    public MovieDto(long id, String title) {
        this.id = id;
        this.title = title;
    }
}
