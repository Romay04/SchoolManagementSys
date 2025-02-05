package com.JavaMiniProject.SchoolManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "previous_academic_details")
@Data
public class PreviousAcademicDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String lastSchoolAttended;
    @Column(name = "last_class_completed", nullable = false)
    private String lastClassCompleted;
    private String previousResults;
    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
}
