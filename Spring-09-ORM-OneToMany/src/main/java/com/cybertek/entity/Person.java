package com.cybertek.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person") //mappedBy drop the ownership, and do not create additional table
    //this is how to use OneToMany which do not create additional table, preferred way
    private List<Address>  addresses; //one to many relations, one person may have multiple addresses

//    @OneToMany
//    @JoinColumn(name="personId") //not a good way
//    private List<Address> addresses;

}
