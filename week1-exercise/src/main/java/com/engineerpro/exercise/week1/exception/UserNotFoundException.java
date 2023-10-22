package com.engineerpro.exercise.week1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserNotFoundException extends Exception {
    private Long notFoundId;
}