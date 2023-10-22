package com.engineerpro.exercise.week1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import org.springframework.stereotype.Service;

import com.engineerpro.exercise.week1.model.Movies;
import com.engineerpro.exercise.week1.model.Users;
import com.engineerpro.exercise.week1.repository.MoviesRepo;
import com.engineerpro.exercise.week1.repository.UsersRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Data
public class UsersServiceImp implements UsersService {

    final UsersRepo usersRepo;
    final MoviesRepo moviesRepo;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addMovie(Long userId, Long movieId) throws Exception {
        Users usersFromDb = usersRepo.findById(userId).orElse(null);
        if (usersFromDb == null)
            throw new Exception();

        Movies moviesFromDb = moviesRepo.findById(movieId).orElse(null);
        if (moviesFromDb == null)
            throw new Exception();
        
        Set<Movies> likedMovies = usersFromDb.getMovies();
        likedMovies.add(moviesFromDb);
        entityManager.persist(usersFromDb);
    }

    public void removeMovie(Long userId, Long movieId) throws Exception {
        Users usersFromDb = usersRepo.findById(userId).orElse(null);
        if (usersFromDb == null)
            throw new Exception();

        Movies moviesFromDb = moviesRepo.findById(movieId).orElse(null);
        if (moviesFromDb == null)
            throw new Exception();
        
        Set<Movies> likedMovies = usersFromDb.getMovies();
        likedMovies.remove(moviesFromDb);
        entityManager.persist(usersFromDb);
    }

    @Override
    public List<Movies> findAllMovies(Long userId) throws Exception {
        Users usersFromDb = usersRepo.findById(userId).orElse(null);
        if (usersFromDb == null)
            throw new Exception();

        Set<Movies> likedMovies = usersFromDb.getMovies();

        return new ArrayList<>(likedMovies);
        
    }
}