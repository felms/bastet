package com.bastet.controller;

import com.bastet.entity.Cat;
import com.bastet.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/")
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @GetMapping("/cats")
    public List<Cat> listAll() {
        return catRepository.findAll();
    }

    @GetMapping("/cats/{id}")
    public Cat findCat(@PathVariable("id") Long id) {
        return catRepository.findById(id).get();
    }

    @PostMapping
    public void insertCat(@RequestBody Cat cat) {
        catRepository.save(cat);
    }

    @PutMapping("/cats/{id}")
    public void updateCat(@PathVariable("id") Long id, @RequestBody Cat cat) {
        Cat cat0 = catRepository.findById(id).get();
        cat0.setName(cat.getName());
        cat0.setOwner(cat.getOwner());
        cat0.setBirth(cat.getBirth());

        catRepository.save(cat0);
    }

    @DeleteMapping("/cats/{id}")
    public void deleteCat(@PathVariable("id") Long id) {
        catRepository.deleteById(id);
    }
}
