package com.jiraapi.demo.jira.issue.updateissue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiraapi.demo.jira.issue.Fields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Update {

    @JsonProperty("summary")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Summary> summary;

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Label> labels;

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Component> components;

    @JsonProperty("assignee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Assignee> assignee;

    @JsonProperty("comment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Comment> comment;

}
