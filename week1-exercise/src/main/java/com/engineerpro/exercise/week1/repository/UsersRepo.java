package com.engineerpro.exercise.week1.repository;

import org.springframework.data.repository.CrudRepository;
import com.engineerpro.exercise.week1.model.Users;

public interface UsersRepo extends CrudRepository<Users, Long> {

  Users findById(long id);

}