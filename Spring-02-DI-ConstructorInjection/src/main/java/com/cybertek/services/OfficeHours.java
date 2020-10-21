package com.cybertek.services;

import com.cybertek.interfaces.ExtraSession;

public class OfficeHours implements ExtraSession {
    @Override
    public int getHours() {
        return 5;
    }
}
