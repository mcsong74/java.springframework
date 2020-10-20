package services;

import interfaces.Staff;

public class FullTimeStaff implements Staff {
    @Override
    public void createAccount(){
        System.out.println("Full Time Staff!!!");
    }


}
