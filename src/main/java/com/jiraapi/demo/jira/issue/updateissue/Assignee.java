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
public class Assignee {
    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("set")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set set;

    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Add add;

    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String remove;

    public Assignee(String name){
        this.name = name;
    }
}
