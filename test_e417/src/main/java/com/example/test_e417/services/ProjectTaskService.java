package com.example.test_e417.services;

import com.example.test_e417.domain.ProjectTask;
import com.example.test_e417.repositories.BacklogRepository;
import com.example.test_e417.repositories.ProjectRepository;
import com.example.test_e417.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(){

        //PTs to be added to a specific project, project != null, BL exists
        //set the bl to pt
        //we want our project ... IDPRO-1 IDPRO-2 ...100 101
        //Update the BL SEQUENCE

        //INITIAL priority when priority is null
        //INITIAL status when status is null

    }
}
