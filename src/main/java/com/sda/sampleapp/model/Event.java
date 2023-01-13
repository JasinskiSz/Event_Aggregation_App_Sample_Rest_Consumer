package com.sda.sampleapp.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startingDateTime;
    private LocalDateTime endingDateTime;
    private Image image;
    private Set<String> usersNicknames;
    private String ownerNickname;
}
