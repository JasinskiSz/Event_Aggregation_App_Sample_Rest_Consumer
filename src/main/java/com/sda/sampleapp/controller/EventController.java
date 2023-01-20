package com.sda.sampleapp.controller;

import com.sda.sampleapp.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping({"/", "/home"})
public class EventController {
    private final EventService service;

    @GetMapping
    public String home(ModelMap map) {
        map.addAttribute("events", service.getAllFutureEvents());
        return "event-list";
    }

    @GetMapping(params = {"start", "end"})
    public String home(ModelMap map,
                       @RequestParam("start") LocalDateTime start,
                       @RequestParam("end") LocalDateTime end) {
        map.addAttribute("events", service.getEventsByDateRange(start, end));
        return "event-list";
    }
}
