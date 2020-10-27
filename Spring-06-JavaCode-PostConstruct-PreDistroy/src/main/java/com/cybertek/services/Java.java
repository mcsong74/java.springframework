package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Java implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Java teaching hours = 30 hr");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("------ Executing post construct!!! ------");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("------ Executing pre destroy!!! ------");
    }
}
