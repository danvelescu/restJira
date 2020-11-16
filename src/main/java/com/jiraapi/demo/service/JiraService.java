package com.jiraapi.demo.service;


import com.jiraapi.demo.MyAuth.myCredentials;
import com.jiraapi.demo.jira.CurentUser;
import com.jiraapi.demo.jira.SesionValue;
import com.jiraapi.demo.jira.SessionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.jiraapi.demo.util.PageUri.*;


@Service
@RequiredArgsConstructor
public class JiraService {

    SesionValue sessionValue = new SesionValue();
    private final RestTemplate restTemplate;
    private String username = myCredentials.username;
    private String password = myCredentials.password;

    public void getSession(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap();

        body.put("username",username);
        body.put("password",password);

        HttpEntity request = new HttpEntity(body, header);
        sessionValue.setSessionValue(
                restTemplate.postForEntity(JIRA_BASE_URL+
                        CREATE_SESSION_URL,
                        request,
                        SessionResponse.class).getBody().getSession().getValue()
        );
    }


    public ResponseEntity<CurentUser> getCurentUser(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("cookie","JSESSIONID="+sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(header);
        return restTemplate.exchange(JIRA_BASE_URL+GET_CURRENT_USER,HttpMethod.GET,request,CurentUser.class);
    }
}
