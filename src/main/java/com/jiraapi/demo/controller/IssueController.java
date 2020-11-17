package com.jiraapi.demo.controller;


import com.jiraapi.demo.exceptions.IssueException;
import com.jiraapi.demo.jira.issue.Issue;
import com.jiraapi.demo.jira.issue.updateissue.Comment;
import com.jiraapi.demo.jira.issue.updateissue.UpdateIssue;
import com.jiraapi.demo.service.IssueService;
import com.jiraapi.demo.service.JiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.jiraapi.demo.util.PageUri.CREATE;
import static com.jiraapi.demo.util.PageUri.ISSUE;

@Controller
@RequiredArgsConstructor
@RequestMapping(ISSUE)
public class IssueController {

    private final IssueService issueService;

    @PostMapping(CREATE)
    public ResponseEntity<String> createIssue(@RequestBody Issue issue) throws IssueException {
        try {
            return ResponseEntity.ok("Issue :" + issueService.createIssue(issue) + " was created");
        } catch (IssueException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateIssue(@PathVariable String id, @RequestBody UpdateIssue updateIssue) {
        try {
            return ResponseEntity.ok("Issue :" + issueService.updateIssue(updateIssue, id) + " was updated");
        } catch (IssueException issueException) {
            issueException.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(issueException.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIssue(@PathVariable String id) {
        return ResponseEntity.ok(issueService.deleteIssue(id));
    }


    @RequestMapping("/{id}/assignTo={username}")
    public ResponseEntity<String> assignTo(@PathVariable String id, @PathVariable String username) {
        return ResponseEntity.ok(issueService.addAssigne(id , username));
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<String> addComment(@PathVariable String id, @RequestBody Comment comment) {
        return ResponseEntity.ok(issueService.addComment(id, comment));
    }

    @DeleteMapping("/{id}/comment/{commentID}")
    public ResponseEntity<String> deleteComment(@PathVariable String id, @PathVariable String commentID) {
        return ResponseEntity.ok(issueService.deleteComment(id, commentID));
    }


}
