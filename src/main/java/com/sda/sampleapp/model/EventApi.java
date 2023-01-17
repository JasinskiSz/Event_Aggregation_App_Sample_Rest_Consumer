package com.sda.sampleapp.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventApi {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startingDateTime;
    private LocalDateTime endingDateTime;
    private String imageUrl;
    private Set<String> usersNicknames;
    private String ownerNickname;
}
