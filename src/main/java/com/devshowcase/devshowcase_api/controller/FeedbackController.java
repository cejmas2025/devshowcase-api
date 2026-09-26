package com.devshowcase.devshowcase_api.controller;

import com.devshowcase.devshowcase_api.dto.FeedbackDTO;
import com.devshowcase.devshowcase_api.model.Feedback;
import com.devshowcase.devshowcase_api.repository.FeedbackRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
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

        return repository.save(feedback);
    }
}