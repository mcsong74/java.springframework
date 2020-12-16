package com.orm2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
@Setter
@Getter
@NoArgsConstructor
public class Departments extends BaseEntity{

    private String department;
    private String division;

    public Departments(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
