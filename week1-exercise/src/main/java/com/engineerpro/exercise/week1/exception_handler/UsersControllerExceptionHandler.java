package com.engineerpro.exercise.week1.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.engineerpro.exercise.week1.dto.response.GeneralResponseDto;
import com.engineerpro.exercise.week1.exception.MovieNotFoundException;
import com.engineerpro.exercise.week1.exception.UserNotFoundException;

@ControllerAdvice
public class UsersControllerExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    private ResponseEntity<?> handleMovieNotFoundException(MovieNotFoundException exception){
        GeneralResponseDto res = new GeneralResponseDto();
        res.setResult_message("Movie id: " + exception.getNotFoundId() + " does not exist");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(res);
    }
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception){
        GeneralResponseDto res = new GeneralResponseDto();
        res.setResult_message("User id: " + exception.getNotFoundId() + " does not exist");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(res);
    }
}