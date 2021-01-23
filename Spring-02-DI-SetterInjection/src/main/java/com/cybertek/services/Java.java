package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import lombok.Data;


public class Java implements Course {
    private ExtraSession extraSession;

    public void setExtraSession(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }


//    private OfficeHours officeHours;
//    public Java(){
//
//    }
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }
//
//    public void setOfficeHours(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }
//


    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours: " + (20 + extraSession.getHours()));
    }
}
