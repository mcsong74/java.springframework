package com.cybertek.entity;

import com.cybertek.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="parents")
public class Parent extends BaseEntity{

    private LocalDate birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String profession;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String username;




}
