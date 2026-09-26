package com.devshowcase.devshowcase_api.repository;

import com.devshowcase.devshowcase_api.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}