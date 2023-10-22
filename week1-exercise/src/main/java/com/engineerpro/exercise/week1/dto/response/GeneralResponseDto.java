package com.engineerpro.exercise.week1.dto.response;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class GeneralResponseDto {
    @NotNull(message = "Result message must not be null")
    private String result_message;
}