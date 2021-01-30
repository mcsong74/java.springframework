package com.cybertek.entity;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="address")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "teacher"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity{
    private String street;
    private String country;
    private String state;
    private String city;

    @Column(name="postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "address")
//    @JsonBackReference //either one can be implemented
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    //added ignore in class level
    private Teacher teacher;

    private Integer currentTemperature;

    private Integer getCurrentTemperature(){
        // get the temp
        return consumeTemp(this.city);
    }
    private Integer consumeTemp(String city){
        //consme temp from 3rd part api by city and return the temperature.
        return 5;
    }

}
