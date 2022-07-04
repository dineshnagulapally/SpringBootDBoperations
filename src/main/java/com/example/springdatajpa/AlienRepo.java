package com.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    public List<Alien> findByAidGreaterThan(int id);

    @Query("from Alien where name=?1")
    public List<Alien> findByTechSorted(String name);
}
