package com.example.shellStudents.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + ", возраст " + age;
    }




}
