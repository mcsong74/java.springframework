package com.cybertek.entity;

import com.cybertek.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="addresses")
public class Address extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private String City;
    private String country;
    private Integer currentTemperature;
    private String postalCode;
    private String state;
    private String street;

    @OneToOne
    @JoinColumn(name="id")
    private Parent parent;

    @OneToOne
    @JoinColumn(name="id")
    private Student student;

}
