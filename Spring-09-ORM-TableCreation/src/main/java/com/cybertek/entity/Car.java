package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //relation mapping heppens
public class Car {
    @Id
    private int id;
    private int year;
    private String make;
    private String model;


}
