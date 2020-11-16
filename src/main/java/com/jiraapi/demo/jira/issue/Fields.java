package com.jiraapi.demo.jira.issue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fields {
    @JsonProperty("project")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Project project;

    @JsonProperty("summary")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> labels;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonProperty("issuetype")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private IssueType issuetype;


}
