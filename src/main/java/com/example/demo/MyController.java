package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class MyController {

    @GetMapping("/api")
    public Map<String, Object> getInfo(
            @RequestParam(name = "slack_name") String slackName,
            @RequestParam(name = "track") String track) {

        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);

        // Format the UTC time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String utcTime = zonedDateTime.format(formatter);

        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        // Format the current day
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE"); // "EEEE" represents the full day name
        String current_day = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        Map<String, Object> response = new HashMap<>();
        response.put("slack_name", slackName);
        response.put("track", track);
        response.put("current_day", current_day);
        response.put("utc_time", utcTime);
        response.put("github_file_url", "https://github.com/oghuanlan-kingsley/Backend/blob/main/src/main/java/com/example/demo/MyController.java");
        response.put("github_repo_url", "https://github.com/oghuanlan-kingsley/Backend");
        response.put("status_code", "200");

        return response;
    }
}
