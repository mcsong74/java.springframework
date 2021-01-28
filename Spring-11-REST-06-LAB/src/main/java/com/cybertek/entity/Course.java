package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="course")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}, ignoreUnknown = true)
public class Course extends BaseEntity{

    private String name;
    @Column(columnDefinition = "TEXT") //unlimited description
    private String description;
}
