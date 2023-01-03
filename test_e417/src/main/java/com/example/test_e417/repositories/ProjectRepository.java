package com.example.test_e417.repositories;

import com.example.test_e417.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAll();

    Project findByProjectIdentifier(String projectId);

    Iterable<Project>findAllByProjectLeader(String username);
}
