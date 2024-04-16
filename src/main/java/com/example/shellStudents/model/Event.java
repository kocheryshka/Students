package com.example.shellStudents.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Event {
    private final EventType type;
    private final int id;
}
