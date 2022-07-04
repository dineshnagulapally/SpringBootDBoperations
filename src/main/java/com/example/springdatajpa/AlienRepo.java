package com.example.springdatajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
    public List<Alien> findByAidGreaterThan(int id);

    @Query("from Alien where name=?1")
    public List<Alien> findByTechSorted(String name);
}
