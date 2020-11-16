package com.jiraapi.demo.jira.issue.updateissue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiraapi.demo.jira.issue.Fields;
import com.jiraapi.demo.jira.issue.IssueType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIssue {

    @JsonProperty("update")
    private Update update;

}
