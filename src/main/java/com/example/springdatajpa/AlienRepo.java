package com.example.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
    public List<Alien> findByAidGreaterThan(int id);
}
