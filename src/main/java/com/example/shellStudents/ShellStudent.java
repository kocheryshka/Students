package com.example.shellStudents;

import com.example.shellStudents.service.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ShellStudent {

    private final Students students;

    @ShellMethod(key = "show", value = "Показать все записи")
    public String showStudents(){
        return students.show();
    }

    @ShellMethod(key = "add", value = "Добавить запись")
    public void add(String firstName, String lastName, int age){
        students.add(firstName, lastName, age);
    }

    @ShellMethod(key = "del", value = "Удалить запись")
    public String del(int id){
        boolean result = students.delete(id);
        if (!result){
            return "Студент с id = " + id + " не существует";
        }
        return null;
    }

    @ShellMethod(key = "delall", value = "Удалить все записи")
    public String clear(){
        students.deleteAll();
        return "Список студентов очищен";
    }

}
