package com.example.test_e417.services;

import com.example.test_e417.domain.Backlog;
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

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){

        //Exception: Project not found

        //PTs to be added to a specific project, project != null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the bl to pt
        projectTask.setBacklog(backlog);
        //we want our project ... IDPRO-1 IDPRO-2 ...100 101
        Integer BacklogSequence = backlog.getPTSequence();
        //Update the BL SEQUENCE
        BacklogSequence++;

        //Add Sequence to Project Task
        projectTask.setProjectSequence(backlog.getProjectIdentifier()+"-"+BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        //INITIAL priority when priority is null
        //if(projectTask.getPriority() == 0 || projectTask.getPriority() == null){
        //    projectTask.setPriority(3);
        //}
        //INITIAL status when status is null
        if (projectTask.getStatus() == "" || projectTask.getStatus() == null){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }
}
