package com.jiraapi.demo.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectException extends Exception {
    private String message;

    public ProjectException(String message, String projectId) {
        this.message = message + "Project id:" + projectId;
    }
}
