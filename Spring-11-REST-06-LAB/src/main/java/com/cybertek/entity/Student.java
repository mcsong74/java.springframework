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
@Table(name="students")
public class Student extends BaseEntity{

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parentId")
    private Parent parent;

    @OneToOne
    @JoinColumn(name="addressId")
    private Address address;


}
