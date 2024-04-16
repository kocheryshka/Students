package com.example.shellStudents.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class Event extends ApplicationEvent {
    private final EventType type;
    private final int id;

    public Event(Object source, EventType type, int id) {
        super(source);
        this.type = type;
        this.id = id;
    }
}
