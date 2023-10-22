package com.engineerpro.exercise.week1.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.engineerpro.exercise.week1.dto.request.AddMovieRequestDto;
import com.engineerpro.exercise.week1.dto.request.RemoveMovieRequestDto;
import com.engineerpro.exercise.week1.dto.response.AddMovieResponseDto;
import com.engineerpro.exercise.week1.dto.response.GetMoviesResponseDto;
import com.engineerpro.exercise.week1.dto.response.RemoveMovieResponseDto;
import com.engineerpro.exercise.week1.model.Movies;
import com.engineerpro.exercise.week1.service.UsersServiceImp;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
@Data
public class UsersController {

    final UsersServiceImp usersServiceImp;

    @PostMapping("/{id}/like")
    public ResponseEntity<?> save(
        @PathVariable Long id, @Valid @RequestBody AddMovieRequestDto addMovieRequestDto
        ) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("User id is not valid");
        if (addMovieRequestDto == null)
            return ResponseEntity.badRequest().body("Request body is not valid");
        
        usersServiceImp.addMovie(id, addMovieRequestDto.getMovieId());
        
        AddMovieResponseDto res = new AddMovieResponseDto();
        res.setResult_message("Success");
        
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{id}/unlike")
    public ResponseEntity<?> delete(
        @PathVariable Long id, @Valid @RequestBody RemoveMovieRequestDto removeMovieRequestDto
        ) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("User id is not valid");
        if (removeMovieRequestDto == null)
            return ResponseEntity.badRequest().body("Request body is not valid");
        
        usersServiceImp.addMovie(id, removeMovieRequestDto.getMovieId());
        
        RemoveMovieResponseDto res = new RemoveMovieResponseDto();
        res.setResult_message("Success");

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<GetMoviesResponseDto> findAll(@PathVariable Long id) throws Exception {
        List<Movies> movies = usersServiceImp.findAllMovies(id);

        GetMoviesResponseDto res = new GetMoviesResponseDto();
        res.setResult_message("Success");
        res.setMovies(movies);
        return ResponseEntity.ok().body(res);
    }
}