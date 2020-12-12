package com.cybertek.entity;

import javax.persistence.*;

@Entity //relation mapping heppens
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private String make;
    private String model;


}
