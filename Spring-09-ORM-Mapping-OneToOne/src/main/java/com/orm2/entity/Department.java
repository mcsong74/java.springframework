package com.orm2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="departments")
@Setter
@Getter
@NoArgsConstructor
public class Department extends BaseEntity{

    private String department;
    private String division;

    @OneToOne(mappedBy = "department")
    private Employee employee;  //bi-directional with Employee and Department

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
