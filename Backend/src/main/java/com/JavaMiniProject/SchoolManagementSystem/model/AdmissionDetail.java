package com.JavaMiniProject.SchoolManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "admission_details")
@Data
public class AdmissionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID admissionNumber;
    @Column(name = "class_for_admission")
    private String classForAdmission;
    @Column(name = "academic_year")
    private int academicYear;
    @Column(name = "preferred_second_language")
    private String preferredSecondLanguage;
    @Column(name = "sibling_in_school")
    private boolean hasSiblingsInSchool;
    private String siblingName;
    private String siblingClass;
    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
}
