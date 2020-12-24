package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //(name="Employees") <- this will change Entity name to Employees
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends BaseEntity{
//    @Id
//    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer salary;

    @ManyToOne  //no need cascade because department will be entered in the database
    @JoinColumn(name="department")
    private Department department;

    @ManyToOne
    @JoinColumn(name="regionId")
    private Region region;

}
