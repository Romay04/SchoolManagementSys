package com.JavaMiniProject.SchoolManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "parent_guardian")
@Data
public class ParentGuardian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String emailAddress;
    private String occupation;
    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
}
