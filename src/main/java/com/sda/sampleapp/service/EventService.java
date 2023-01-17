package com.sda.sampleapp.service;

import com.sda.sampleapp.dto.EventApiWrapper;
import com.sda.sampleapp.model.EventApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class EventService {
    private final RestTemplate restTemplate;
    private final String externalApiUrl;

    @Autowired
    public EventService(@Value("${event.aggregation.application.api.events.url}") String externalApiUrl, RestTemplate restTemplate) {
        this.externalApiUrl = externalApiUrl;
        this.restTemplate = restTemplate;
    }

    public List<EventApi> getAllFutureEvents() {
        EventApiWrapper eventApiWrapper;

        try {
            eventApiWrapper = restTemplate.getForObject(externalApiUrl, EventApiWrapper.class);
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while getting events", e);
        }

        return Objects.requireNonNull(eventApiWrapper).getEventApiList();
    }
}
