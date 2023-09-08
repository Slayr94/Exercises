package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @GetMapping("/info")
    public Map<String, Object> getInfo(
            @RequestParam(name = "slack_name") String slackName,
            @RequestParam(name = "track") String track) {


        Map<String, Object> response = new HashMap<>();
        response.put("slack_name", slackName);
        response.put("track", track);
        response.put("currentDay", LocalDateTime.now().getDayOfWeek().toString());
        response.put("github_file_url", "https://github.com/username/repo/blob/main/file_name.ext");
        response.put("github_repo_url", "https://github.com/username/repo");
        response.put("status_code", "200");

        return response;
    }
}
