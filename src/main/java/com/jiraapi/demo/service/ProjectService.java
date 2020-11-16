package com.jiraapi.demo.service;

import com.jiraapi.demo.jira.project.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.jiraapi.demo.util.PageUri.*;


@Service
@RequiredArgsConstructor
public class ProjectService {
    private final JiraService jiraService;
    private final RestTemplate restTemplate;

    public Optional<Project> getProjectByKey(String key){
        jiraService.getSession();
        HttpHeaders header = new HttpHeaders();

        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("cookie", "JSESSIONID=" + jiraService.sessionValue.getSessionValue());

        HttpEntity request = new HttpEntity<>(header);
        return Optional.ofNullable(restTemplate.exchange(JIRA_BASE_URL + GET_PROJECT + key,
                HttpMethod.GET, request,
                Project.class).getBody());

    }
}
