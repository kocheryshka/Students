package com.example.shellStudents.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "app.init-students", havingValue = "true")
public class InitStudents {

    private final Students students;

    @Value("${app.file-path}")
    private String filePath;

    @PostConstruct
    public void loadStudents(){
        Resource resource = new ClassPathResource(filePath);
        try {
            InputStream inputStream = resource.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            String file = FileCopyUtils.copyToString(reader);
            String[] strings = file.split(System.lineSeparator());
            for (String string : strings) {
                String[] parts = string.split(";");
                if (parts.length != 3) {
                    throw new IOException();
                }
                students.add(parts[0], parts[1], Integer.parseInt(parts[2]));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}