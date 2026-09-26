package com.devshowcase.devshowcase_api.controller;

import com.devshowcase.devshowcase_api.dto.ProfileDTO;
import com.devshowcase.devshowcase_api.dto.ProfileResponseDTO;
import com.devshowcase.devshowcase_api.model.Profile;
import com.devshowcase.devshowcase_api.repository.ProfileRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository repository;

    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Profile> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
public ResponseEntity<ProfileResponseDTO> getById(@PathVariable Long id) {
    return repository.findById(id)
            .map(profile -> new ProfileResponseDTO(
                    profile.getId(),
                    profile.getName(),
                    profile.getEmail(),
                    profile.getBio()
            ))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

    @PostMapping
    public Profile create(@Valid @RequestBody ProfileDTO dto) {
        Profile profile = new Profile();

        profile.setName(dto.getName());
        profile.setEmail(dto.getEmail());
        profile.setBio(dto.getBio());

        return repository.save(profile);
    }
}