package com.devshowcase.devshowcase_api.controller;
import com.devshowcase.devshowcase_api.dto.ProjectDTO; import com.devshowcase.devshowcase_api.model.Project; import com.devshowcase.devshowcase_api.model.Profile; import com.devshowcase.devshowcase_api.model.Technology; import com.devshowcase.devshowcase_api.repository.ProjectRepository; import com.devshowcase.devshowcase_api.repository.ProfileRepository; import com.devshowcase.devshowcase_api.repository.TechnologyRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/projects")
public class ProjectController {
private final ProjectRepository repository;
private final ProfileRepository profileRepository;
private final TechnologyRepository technologyRepository;

public ProjectController(
        ProjectRepository repository,
        ProfileRepository profileRepository,
        TechnologyRepository technologyRepository) {
    this.repository = repository;
    this.profileRepository = profileRepository;
    this.technologyRepository = technologyRepository;
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

    if (dto.getProfileId() != null) {
        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Perfil não encontrado"));

        project.setProfile(profile);
    }

    if (dto.getTechnologyIds() != null) {
        List<Technology> technologies = dto.getTechnologyIds().stream()
                .map(id -> technologyRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Tecnologia não encontrada: " + id)))
                .toList();

        project.setTechnologies(technologies);
    }

    return repository.save(project);
}
}