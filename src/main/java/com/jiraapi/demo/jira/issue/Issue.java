package com.jiraapi.demo.jira.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiraapi.demo.exceptions.ProjectException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    @JsonProperty("fields")
    private Fields fields;

}
