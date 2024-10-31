package com.mitigia.server.controllers;

import com.mitigia.server.models.Project;
import com.mitigia.server.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository repository) {
        this.projectRepository = repository;
    }

    public ResponseEntity<?> getProjects() {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
