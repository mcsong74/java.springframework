package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity //relation mapping heppens
@Table(name = "cars")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String make;
    private String model;

    public Car(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }
}
