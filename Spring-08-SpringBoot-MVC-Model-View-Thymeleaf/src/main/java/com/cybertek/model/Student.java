package com.cybertek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student { //model pure POJO class
    private int id;
    private String firstName;
    private String lastName;

}
