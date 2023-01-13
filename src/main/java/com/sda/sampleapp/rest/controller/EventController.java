package com.sda.sampleapp.rest.controller;

import com.sda.sampleapp.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final RestTemplate restTemplate;

    @GetMapping
    public List<Event> getEvents() {
        String url = "http://localhost:8080/api/v1/events";
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, Event[].class)));
    }
}