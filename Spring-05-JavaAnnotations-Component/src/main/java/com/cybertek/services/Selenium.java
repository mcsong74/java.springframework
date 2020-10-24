package com.cybertek.services;

import com.cybertek.interfaces.Course;

public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teachings hours: 23 hr");
    }
}
