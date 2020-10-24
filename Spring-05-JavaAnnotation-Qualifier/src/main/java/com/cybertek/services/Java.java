package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

//     //field injection, @Qualifier, in field, @Autowired required
//    @Autowired
//    @Qualifier ("officeHours")
//    private ExtraSessions extraSessions;

    //constructor injection using @Qualifier
    private ExtraSessions extraSessions;
    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        //in constructor, autowired not required, if multiple, at least one need it
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Java Class teaching hours: "+(30+extraSessions.getHours())+" hr");
    }
}
