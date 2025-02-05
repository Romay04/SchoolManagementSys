package com.JavaMiniProject.SchoolManagementSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name="Students")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studentId;
    private String passportPhotoPath;
    @NotBlank
    private String fullName;
    @NotNull
    private LocalDate dateOfBirth;
    private Gender gender;
    @NotBlank
    private String nationality;
    @NotBlank
    private String religion;


    
    @Embedded
    private Address residentialAddress;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private ParentGuardian parentGuardians;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private PreviousAcademicDetail previousAcademicDetails;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AdmissionDetail admissionDetail;

    @Embedded
    private MedicalInformation medicalInformation;
}
