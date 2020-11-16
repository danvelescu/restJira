package com.jiraapi.demo.jira.issue.updateissue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Label {
    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String add;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("remove")
    private String remove;
}
