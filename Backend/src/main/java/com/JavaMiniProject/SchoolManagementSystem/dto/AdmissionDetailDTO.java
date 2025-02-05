package com.JavaMiniProject.SchoolManagementSystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDetailDTO {
    @NotBlank
    private String classForAdmission;
    @Min(value = 2020, message = "Academic year must be valid")
    private int academicYear;
    private String preferredSecondLanguage;
    private boolean hasSiblingsInSchool;
    private String siblingName;
    private String siblingClass;
}
