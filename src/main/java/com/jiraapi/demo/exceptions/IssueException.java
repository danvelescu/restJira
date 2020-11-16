package com.jiraapi.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueException extends Exception {
    private String message;

    public IssueException(String mess) {
        this.message = mess;
    }
}
