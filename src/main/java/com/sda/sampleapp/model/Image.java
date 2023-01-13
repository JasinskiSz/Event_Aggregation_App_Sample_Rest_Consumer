package com.sda.sampleapp.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {
    private Long id;
    private String filename;
    private String path;
    private Event event;
}