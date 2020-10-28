package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public int getTeachingHours() {
        return 10;
    }
}
