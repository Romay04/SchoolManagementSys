package com.JavaMiniProject.SchoolManagementSystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDTO {
    @NotNull(message = "Student details are required")
    @Valid
    private StudentDTO student;
    @NotNull(message = "Parent guardian details are required")
    @Valid
    private ParentGuardianDTO parentGuardian;
    @NotNull(message = "Previous acadamic detail is required")
    @Valid
    private PreviousAcademicDetailDTO previousAcadamicDetail;
    @NotNull(message = "Admission detail is required")
    @Valid
    private AdmissionDetailDTO admissionDetail;
}
