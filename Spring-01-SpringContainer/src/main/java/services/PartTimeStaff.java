package services;

import interfaces.Staff;

public class PartTimeStaff implements Staff {
    @Override
    public void createAccount(){
        System.out.println("Part Time Staff !!!");
    }
}
