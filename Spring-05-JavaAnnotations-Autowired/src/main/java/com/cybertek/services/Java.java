package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    //field injection
//    @Autowired
//    private OfficeHours officeHours; //create composition
    @Autowired
    private ExtraSessions extraSessions;    // interface
//    //Constructor injection using @Autowired
//    @Autowired  //inject constructor to Java Component
//    public Java(OfficeHours officeHours) {
//        // autowired constructor
//        this.officeHours = officeHours;
//    }

//    // Setter Injection, no commonly used.  common use is Constructor inject than setter injection
//    public OfficeHours getOfficeHours() {
//        return officeHours;
//    }
//    @Autowired
//    public void setOfficeHours(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Java Class teaching hours: "+(30+extraSessions.getHours())+" hr");
    }
}
