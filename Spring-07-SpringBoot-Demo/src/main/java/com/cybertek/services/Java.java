package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    @Value("${instructor}")
    private String instructorName;
    @Value("${officeHour}")
    private int officeHour;

    private ExtraSession extraSession;

    @Autowired
    public Java(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    @Override
    public int getTeachingHours() {
        System.out.println("Instructor: " + instructorName);
        return 30 + extraSession.getHour() + officeHour;
    }
}
