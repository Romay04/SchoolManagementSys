package com.JavaMiniProject.SchoolManagementSystem.model;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String streetName;
    private int house_number;
    private String city;
    private String region;
    private String country;
}
