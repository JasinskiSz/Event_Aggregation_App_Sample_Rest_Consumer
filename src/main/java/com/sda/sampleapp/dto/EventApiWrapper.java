package com.sda.sampleapp.dto;

import com.sda.sampleapp.model.EventApi;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class EventApiWrapper {
    private List<EventApi> eventApiList;
}
