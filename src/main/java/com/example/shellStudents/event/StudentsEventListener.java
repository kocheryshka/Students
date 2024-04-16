package com.example.shellStudents.event;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentsEventListener {

    @EventListener()
    public void HandleEvent(Event event){
        if (event.getType() == EventType.INSERT){
            System.out.println("Студент с id = " + event.getId() + " успешно добавлен!");
        } else if (event.getType() == EventType.DELETE){
            System.out.println("Студент с id = " + event.getId() + " успешно удален!");
        } else {
            System.out.println("блаблабла");
        }
    }
}
