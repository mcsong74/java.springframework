package com.cybertek.entity;

import com.cybertek.enums.EducationLevel;
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
@Table(name="teachers")
public class Teacher extends BaseEntity{

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String username;

}
