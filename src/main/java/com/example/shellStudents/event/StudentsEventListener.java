package com.example.shellStudents.event;

import com.example.shellStudents.model.Event;
import com.example.shellStudents.model.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentsEventListener {

    private final EventQueue queue;

    @EventListener(ApplicationStartedEvent.class)
    public void startListener(){
        Thread listenerThread = new Thread(() -> {
            while (true){
                Event event = queue.dequeue();
                if (event.getType() == EventType.INSERT){
                    System.out.println("Студент с id = " + event.getId() + " успешно добавлен!");
                } else if (event.getType() == EventType.DELETE){
                    System.out.println("Студент с id = " + event.getId() + " успешно удален!");
                } else {
                    System.out.println("блаблабла");
                }
            }
        });
        listenerThread.start();
    }
}
