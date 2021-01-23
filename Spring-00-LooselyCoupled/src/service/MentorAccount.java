package service;

import implementation.Mentor;

public class MentorAccount {
    //create compositions from interface
    Mentor mentor; //Loosely coupled

    //constructor
    public MentorAccount(Mentor mentor) {
        this.mentor = mentor;   //polymorphism occurs here
    }

    public void manageAccount() {
        this.mentor.createAccount();
    }
}
