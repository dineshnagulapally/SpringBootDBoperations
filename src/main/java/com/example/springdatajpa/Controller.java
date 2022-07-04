package com.example.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    AlienRepo repo;
    @RequestMapping("/alien")
    public String getAlien(@RequestParam("id") int aid){
        Optional<Alien> optional = repo.findById(aid);
        System.out.println(optional.get());
        return "Hi";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public void saveAlien(@RequestBody Alien a){
        repo.save(a);
    }
    @RequestMapping("/greater")
    public List<Alien> greaterthan(@RequestParam("id") int aid){
        List<Alien> optional = repo.findByAidGreaterThan(aid);
        for (Alien a:
             optional) {
            System.out.println(a);
        }

        List<Alien> sort = repo.findByTechSorted("Aerial");
        for (Alien b:
                sort) {
            System.out.println(b);
        }
        return new ArrayList<>();
    }
    @RequestMapping("get/{id}")
    public String getA(@PathVariable("id") int id){
        return repo.findById(id).toString();
    }
}
