package com.devshowcase.devshowcase_api.controller;

import com.devshowcase.devshowcase_api.dto.FeedbackDTO;
import com.devshowcase.devshowcase_api.model.Feedback;
import com.devshowcase.devshowcase_api.model.Project;
import com.devshowcase.devshowcase_api.repository.FeedbackRepository;
import com.devshowcase.devshowcase_api.repository.ProjectRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackRepository repository;
    private final ProjectRepository projectRepository;

    public FeedbackController(
            FeedbackRepository repository,
            ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feedback create(@Valid @RequestBody FeedbackDTO dto) {
        Feedback feedback = new Feedback();

        feedback.setAuthor(dto.getAuthor());
        feedback.setComment(dto.getComment());

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Projeto nao encontrado"));

        feedback.setProject(project);

        return repository.save(feedback);
    }
}