package com.jiraapi.demo.service;

import com.jiraapi.demo.exceptions.IssueException;
import com.jiraapi.demo.jira.issue.Issue;
import com.jiraapi.demo.jira.issue.updateissue.Assignee;
import com.jiraapi.demo.jira.issue.updateissue.Comment;
import com.jiraapi.demo.jira.issue.updateissue.UpdateIssue;
import com.jiraapi.demo.jira.issue.dto.IssueResponse;
import com.jiraapi.demo.jira.issue.validator.ValidateIssue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;

import static com.jiraapi.demo.util.PageUri.*;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final JiraService jiraService;
    private final RestTemplate restTemplate;

    public String createIssue(Issue issue) throws IssueException {
        ValidateIssue.validateIssue(issue);

        HttpEntity request = new HttpEntity(issue, getHeader());

        return restTemplate.exchange(JIRA_BASE_URL+CREATE_ISSUE,
                HttpMethod.POST,
                request,
                IssueResponse.class).getBody().getId();
    }


    public String updateIssue(UpdateIssue updateIssue,String issueID) throws IssueException {
        ValidateIssue.validateUpdateIssue(updateIssue);

        HttpEntity request = new HttpEntity(updateIssue,getHeader());

        return restTemplate.exchange(JIRA_BASE_URL+CREATE_ISSUE+issueID,
                HttpMethod.PUT,
                request,
                IssueResponse.class).getStatusCode().toString();
    }

    public String addComment(String id, Comment comment){

        HttpEntity request = new HttpEntity(comment,getHeader());


        return restTemplate.exchange(JIRA_BASE_URL+CREATE_ISSUE+id+"/comment",
                HttpMethod.POST,
                request,
                IssueResponse.class).getStatusCode().toString();
    }


    public String deleteIssue(String issueID){
        HttpEntity  request = new HttpEntity(getHeader());
        try {
            restTemplate.exchange(JIRA_BASE_URL + DELETE_ISSUE.concat(issueID),
                    HttpMethod.DELETE, request,
                    String.class);
            return "Issue with id - " + issueID + " was deleted successfully";
        } catch (HttpClientErrorException clientErrorException){
            return "You don't have permission to delete this issue";
        }
        catch (Exception  e) {
            return "No Issue with ID " +issueID;
        }
    }

    public String addAssigne(String issueID,String username){
        Assignee assignee = new Assignee(username);

        HttpEntity request = new HttpEntity(assignee,getHeader());

        return restTemplate.exchange(JIRA_BASE_URL+CREATE_ISSUE+issueID+"/assignee",
                HttpMethod.PUT,
                request,
                IssueResponse.class).getStatusCode().toString();
    }



    public String deleteComment(String id, String commentID) {
       HttpEntity request = new HttpEntity(getHeader());
       return restTemplate.exchange(JIRA_BASE_URL+CREATE_ISSUE+id+"/comment/"+commentID,
               HttpMethod.DELETE,request,IssueResponse.class).getStatusCode().toString();

    }




    private HttpHeaders getHeader(){
        jiraService.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + jiraService.sessionValue.getSessionValue());
        return headers;
    }
}
