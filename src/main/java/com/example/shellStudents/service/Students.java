package com.example.shellStudents.service;

import com.example.shellStudents.event.EventQueue;
import com.example.shellStudents.model.Event;
import com.example.shellStudents.model.EventType;
import com.example.shellStudents.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Component
public class Students {

    private final Map<Integer, Student> studentList = new HashMap<>();
    private final EventQueue eventQueue;

    public void add(String firstName, String lastName, int age){
        int id = getNextId();
        studentList.put(id, new Student(id, firstName, lastName, age));
        eventQueue.enqueue(Event.builder()
                .type(EventType.INSERT)
                .id(id)
                .build());
    }

    public String show(){
        StringBuilder builder = new StringBuilder();
        for (Student student: studentList.values()){
            builder.append(student).append(System.lineSeparator());
        }
        return builder.toString();
    }

    public boolean delete(int id){
        if (studentList.containsKey(id)) {
            studentList.remove(id);
            eventQueue.enqueue(Event.builder()
                    .type(EventType.DELETE)
                    .id(id)
                    .build());
            System.out.println(eventQueue.getQueueLength());
            return true;
        }
        return false;
    }

    public void deleteAll(){
        studentList.clear();
    }

    private int getNextId(){
        return studentList.keySet()
                .stream()
                .mapToInt(i -> i)
                .max()
                .orElse(0) + 1;
    }

}
