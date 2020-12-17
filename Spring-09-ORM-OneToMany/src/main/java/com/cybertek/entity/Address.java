package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    private Long id;

    private String street;
    private String zipCode;
    @ManyToOne // looks bi-directional but actually create 2 uni directional, not a good design
    //cannot use mappedBy here
    private Person person; //many address can be assigned to one person
}
