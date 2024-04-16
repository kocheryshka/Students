package com.example.shellStudents.config;

import com.example.shellStudents.event.EventQueue;
import com.example.shellStudents.event.StudentsEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventQueueConfig {

    @Bean
    public StudentsEventListener studentsEventListener(EventQueue eventQueue){
        return new StudentsEventListener(eventQueue);
    }
}
