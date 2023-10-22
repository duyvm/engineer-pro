package com.engineerpro.exercise.week1.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Data
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="LIKES", 
        joinColumns=@JoinColumn(name="USERS_ID"),
        inverseJoinColumns=@JoinColumn(name="MOVIES_ID")
    )
    private Set<Movies> movies = new HashSet<Movies>();
}
