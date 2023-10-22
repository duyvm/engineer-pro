package com.engineerpro.exercise.week1.exception_handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.engineerpro.exercise.week1.dto.response.GeneralResponseDto;

@ControllerAdvice
@Slf4j
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception) {
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            log.error(fieldName + ": " + errorMessage);
        });
        GeneralResponseDto res = new GeneralResponseDto();
        res.setResult_message("Bad request");
        return ResponseEntity.badRequest().body(res);
    }
}