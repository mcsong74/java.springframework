package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    private OfficeHours officeHours; //create composition

    //Constructor injection using @Autowired
    @Autowired  //inject constructor to Java Component
    public Java(OfficeHours officeHours) {
        // autowired constructor
        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Java Class teaching hours: "+(30+officeHours.getHours())+" hr");
    }
}
