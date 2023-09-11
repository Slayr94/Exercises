package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @GetMapping("/api")
    public Map<String, Object> getInfo(
            @RequestParam(name = "slack_name") String slackName,
            @RequestParam(name = "track") String track) {


        Map<String, Object> response = new HashMap<>();
        response.put("slack_name", slackName);
        response.put("track", track);
        response.put("current_day", LocalDateTime.now().getDayOfWeek().toString().toLowerCase());
        response.put("utc_time", LocalDateTime.now(ZoneOffset.UTC).toString());
        response.put("github_file_url", "https://github.com/oghuanlan-kingsley/Backend/blob/main/src/main/java/com/example/demo/MyController.java");
        response.put("github_repo_url", "https://github.com/oghuanlan-kingsley/Backend");
        response.put("status_code", "200");

        return response;
    }
}
