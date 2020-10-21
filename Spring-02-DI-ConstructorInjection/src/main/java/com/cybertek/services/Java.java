package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;

public class Java implements Course {
    //    OfficeHours officeHours;

//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }
//    public int x;

    ExtraSession extraSession;  //more efficient to inject through interface(ExtraSession) than class (OfficeHours)

    public Java(ExtraSession extraSession) {

        this.extraSession = extraSession;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+(20+extraSession.getHours()));

//        System.out.println("Weekly Teaching Hours : "+(20+officeHours.getHours()));

    }
}
