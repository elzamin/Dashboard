package com.example.test_e417.services;

import com.example.test_e417.domain.Backlog;
import com.example.test_e417.domain.Project;
import com.example.test_e417.exceptions.ProjectIdException;
import com.example.test_e417.repositories.BacklogRepository;
import com.example.test_e417.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    public Project saveOUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            if (project.getId() == null) {
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if (project.getId() != null) {
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + "already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID '" + projectId + "' does not exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects() {

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null) {
            throw new ProjectIdException("Cannot Project with ID '" + projectId + "'. This project does not exist");
        }

        projectRepository.delete(project);
    }
}
