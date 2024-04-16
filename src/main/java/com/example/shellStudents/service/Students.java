package com.example.shellStudents.service;

import com.example.shellStudents.event.Event;
import com.example.shellStudents.event.EventType;
import com.example.shellStudents.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Component
public class Students {

    private final Map<Integer, Student> studentList = new HashMap<>();
    private final ApplicationEventPublisher publisher;

    public void add(String firstName, String lastName, int age){
        int id = getNextId();
        studentList.put(id, new Student(id, firstName, lastName, age));
        publisher.publishEvent(new Event(this, EventType.INSERT, id));
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
            publisher.publishEvent(new Event(this, EventType.DELETE, id));
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
