package com.mitigia.server.services;

import com.mitigia.server.models.Project;
import com.mitigia.server.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Project> getProjectByLicencePlate(String licencePlate) {
        return projectRepository.findProjectByLicencePlate(licencePlate);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
