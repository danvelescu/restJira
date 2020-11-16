package com.jiraapi.demo.controller;

import com.jiraapi.demo.service.JiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jiraapi.demo.util.PageUri.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CREATE_SESSION)
public class JiraController {
    private final JiraService jiraService;

    @PostMapping(AUTH)
    public ResponseEntity<String> createSession() {
        jiraService.getSession();
        return ResponseEntity.ok("Current session was created");
    }

    @GetMapping(CURRENT_USER)
    public ResponseEntity<String> getCurrentUser() {
        return ResponseEntity.ok("Hello user " + jiraService.getCurentUser().getBody().getName());
    }
}
