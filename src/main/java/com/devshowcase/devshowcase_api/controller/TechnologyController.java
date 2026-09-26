package com.devshowcase.devshowcase_api.controller;

import com.devshowcase.devshowcase_api.dto.TechnologyDTO;
import com.devshowcase.devshowcase_api.model.Technology;
import com.devshowcase.devshowcase_api.repository.TechnologyRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyRepository repository;

    public TechnologyController(TechnologyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Technology> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Technology create(@Valid @RequestBody TechnologyDTO dto) {
        Technology technology = new Technology();

        technology.setName(dto.getName());

        return repository.save(technology);
    }
}