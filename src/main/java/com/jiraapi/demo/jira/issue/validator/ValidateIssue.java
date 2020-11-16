package com.jiraapi.demo.jira.issue.validator;

import com.jiraapi.demo.exceptions.IssueException;
import com.jiraapi.demo.jira.issue.Issue;
import com.jiraapi.demo.jira.issue.updateissue.UpdateIssue;

public abstract class ValidateIssue {
    public static boolean validateIssue(Issue issue) throws IssueException {
        if (issue.getFields().getDescription().isEmpty()) {
            throw new IssueException("Discription not found");
        }
        if (issue.getFields().getLabels() == null) {
            throw new IssueException("Labels not found");
        }
        if (issue.getFields().getSummary().isEmpty()) {
            throw new IssueException("summary not found");
        }
        if (issue.getFields().getIssuetype().getName().isEmpty()) {
            throw new IssueException("IssueType name not found");
        }
        if (issue.getFields().getProject().getKey().isEmpty()) {
            throw new IssueException("Project key not found");
        }
        return true;
    }

    public static boolean validateUpdateIssue(UpdateIssue updateIssue) throws IssueException {

        return true;
    }
}
