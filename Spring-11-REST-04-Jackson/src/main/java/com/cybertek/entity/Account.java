package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account_details")
@JsonIgnoreProperties(value={"state", "postalCode"}, ignoreUnknown = true) //this wont show state and postalCode data
public class Account extends BaseEntity {
//    @JsonIgnore  //won't display name field
    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;

    @Enumerated(EnumType.STRING)
//    private UserRole role;
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    @JsonBackReference //dependency
    private User user;

    public Account(String name, String address, String country, String city, String state,
                   Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
