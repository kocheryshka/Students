package com.example.shellStudents.event;

import com.example.shellStudents.model.Event;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EventQueue {
    private final BlockingQueue<Event> queue = new LinkedBlockingQueue<>();

    public void enqueue(Event event){
        try {
            queue.put(event);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public Event dequeue(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public int getQueueLength(){
        return queue.size();
    }
}
