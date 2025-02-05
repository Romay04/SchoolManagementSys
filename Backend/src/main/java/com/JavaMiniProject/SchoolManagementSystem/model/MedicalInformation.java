package com.JavaMiniProject.SchoolManagementSystem.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class MedicalInformation {
    private String bloodType;
    private String allergiesOrConditions;
    private String emergencyContactsName;
    private String emergencyContactsNumber;
}
