package com.devshowcase.devshowcase_api.controller;

import com.devshowcase.devshowcase_api.dto.ProjectDTO;
import com.devshowcase.devshowcase_api.model.Project;
import com.devshowcase.devshowcase_api.repository.ProjectRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Project> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Project create(@Valid @RequestBody ProjectDTO dto) {
        Project project = new Project();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setUrl(dto.getUrl());

        return repository.save(project);
    }
}