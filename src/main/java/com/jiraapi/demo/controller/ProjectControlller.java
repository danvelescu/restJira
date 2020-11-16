package com.jiraapi.demo.controller;

import com.jiraapi.demo.exceptions.ProjectException;
import com.jiraapi.demo.jira.project.Project;
import com.jiraapi.demo.service.JiraService;
import com.jiraapi.demo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectControlller {
    private final ProjectService projectService;
    private final JiraService jiraService;

    @GetMapping("/project-{id}")
    public ResponseEntity<String> getProjectByKey(@PathVariable String id) throws ProjectException {
        jiraService.getSession();
        Optional<Project> projectOptional = projectService.getProjectByKey(id);
        if (projectOptional.isPresent()) {
            return ResponseEntity.ok(projectOptional.get().toString());
        } else {
            throw new ProjectException("Project not found", id);
        }
    }

}
